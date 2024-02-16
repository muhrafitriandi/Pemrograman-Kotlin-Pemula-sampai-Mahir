package coroutine.kotlin.shared_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import org.junit.jupiter.api.Test
import java.util.*

class SharedFlowTest {
    @Test
    fun testSharedFlowWithoutBuffer() {
        val scope = CoroutineScope(Dispatchers.IO)
        val sharedFlow = MutableSharedFlow<Int>()

        val jobSender = scope.launch {
            repeat(10) {
                println("Send data: $it : ${Date()}")
                sharedFlow.emit(it)
                delay(500)
            }
        }

        val jobReceiver1 = scope.launch {
            repeat(10) {
                sharedFlow
                    .asSharedFlow()
                    .map { "Receive data 1: $it : ${Date()}" }
                    .collect {
                        delay(2_000)
                        println(it)
                    }
            }
        }

        val jobReceiver2 = scope.launch {
            repeat(10) {
                sharedFlow
                    .asSharedFlow()
                    .map { "Receive data 2: $it : ${Date()}" }
                    .collect {
                        delay(4_000)
                        println(it)
                    }
            }
        }

        runBlocking {
            joinAll(jobSender, jobReceiver1, jobReceiver2)
        }
    }

    @Test
    fun testSharedFlowWithBuffer() {
        val scope = CoroutineScope(Dispatchers.IO)
        val sharedFlow = MutableSharedFlow<Int>()

        scope.launch {
            repeat(10) {
                println("Send data: $it : ${Date()}")
                sharedFlow.emit(it)
                delay(500)
            }
        }

        scope.launch {
            repeat(10) {
                sharedFlow
                    .asSharedFlow()
                    .buffer(10)
                    .map { "Receive data 1: $it : ${Date()}" }
                    .collect {
                        delay(2_000)
                        println(it)
                    }
            }
        }

        scope.launch {
            repeat(10) {
                sharedFlow
                    .asSharedFlow()
                    .buffer(10)
                    .map { "Receive data 2: $it : ${Date()}" }
                    .collect {
                        delay(4_000)
                        println(it)
                    }
            }
        }

        runBlocking {
            delay(42_000)
            scope.cancel()
        }
    }
}