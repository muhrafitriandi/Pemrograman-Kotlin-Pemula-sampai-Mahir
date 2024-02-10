package coroutine.kotlin.menggabungkan_context_element

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CombineContextElementTest {
    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    @Test
    fun testCombineContextElement() {
        val scope = CoroutineScope(Dispatchers.IO + CoroutineName("io"))

        val job = scope.launch(newSingleThreadContext("Banana Thread") + CoroutineName("banana")) {
            println("Parent running on: ${Thread.currentThread().name}")

            withContext(Dispatchers.IO) {
                println("Child running on: ${Thread.currentThread().name}")
            }

            println("Parent running on: ${Thread.currentThread().name}")
        }

        runBlocking {
            job.join()
        }
    }
}