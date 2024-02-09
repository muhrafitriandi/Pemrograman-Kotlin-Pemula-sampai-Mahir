package coroutine.kotlin.coroutine_parent_child

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineParentChildTest {
    @Test
    fun testCoroutineParentChild() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            launch {
                delay(4000)
                println("Child 1 Finish ${Thread.currentThread().name}")
            }
            launch {
                delay(6000)
                println("Child 2 Finish ${Thread.currentThread().name}")
            }
            delay(2000)
            println("Parent Finish ${Thread.currentThread().name}")
        }
        runBlocking {
            job.join()
        }
    }
}