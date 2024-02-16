package coroutine.kotlin.state_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import org.junit.jupiter.api.Test

class StateFlowTest {
    @Test
    fun testStateFlow() {
        val scope = CoroutineScope(Dispatchers.IO)
        val stateFlow = MutableStateFlow(0)

        scope.launch {
            repeat(10) {
                println("Send: $it")
                stateFlow.emit(it)
                delay(1000)
            }
        }

        scope.launch {
            repeat(10) {
                stateFlow
                    .asStateFlow()
                    .map { "Receive: $it" }
                    .collect {
                        println(it)
                        delay(2_000)
                    }
            }
        }

        runBlocking {
            delay(12_000)
            scope.cancel()
        }
    }
}