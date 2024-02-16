package coroutine.kotlin.asynchronous_flow

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class AsynchronousFlowTest {
    @Test
    fun testFlow() {
        val flow: Flow<Int> = flow {
            println("Start Flow")
            repeat(10) {
                println("Send: $it")
                emit(it)
            }
        }

        runBlocking {
            flow.collect {
                println("Receive 1 : $it")
                println("----------")
            }

            flow.collect {
                println("Receive 2 : $it")
                println("----------")
            }
        }
    }

    @Test
    fun testAsyncAwait() {
        runBlocking {
            val deferredList = mutableListOf<Deferred<Int>>()

            println("Start Async")
            repeat(10) {
                val deferred = async {
                    println("Send: $it")
                    it
                }
                deferredList.add(deferred)
            }

            deferredList.forEach { deferred ->
                val result = deferred.await()
                println("Receive: $result")
                println("----------")
            }
        }
    }
}