package coroutine.kotlin.memberi_nama_coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineNameTest {
    @Test
    fun testNameCoroutine() {
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch(CoroutineName("parent")) {
            println("Parent running on: ${Thread.currentThread().name}")

            withContext(CoroutineName("child")) {
                println("Child running on: ${Thread.currentThread().name}")
            }

            println("Parent running on: ${Thread.currentThread().name}")
        }

        runBlocking {
            job.join()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    @Test
    fun testNameThread() {
        val scope = CoroutineScope(newSingleThreadContext("Banana Thread"))

        val job = scope.launch(CoroutineName("parent")) {
            println("Parent running on: ${Thread.currentThread().name}")

            withContext(CoroutineName("child")) {
                println("Child running on: ${Thread.currentThread().name}")
            }

            println("Parent running on: ${Thread.currentThread().name}")
        }

        runBlocking {
            job.join()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    @Test
    fun testNameCoroutineDispatcher() {
        val scope = CoroutineScope(newSingleThreadContext("Banana Thread") + CoroutineName("test"))

        val job = scope.launch {
            println("Parent running on: ${Thread.currentThread().name}")

            withContext(Dispatchers.IO + CoroutineName("child")) {
                println("Child running on: ${Thread.currentThread().name}")
            }

            println("Parent running on: ${Thread.currentThread().name}")
        }

        runBlocking {
            job.join()
        }
    }
}