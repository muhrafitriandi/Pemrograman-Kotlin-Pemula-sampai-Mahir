package coroutine.kotlin.flow_exception

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowExceptionTest {
    fun flowNumber(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    @Test
    fun testFlowException() {
        runBlocking {
            flowNumber()
                .map { check(it < 10);it }
                .onEach { println(it) }
                .catch { println("Error: ${it.message}") }
                .onCompletion { println("Process Done.") }
                .collect()
        }
    }
}