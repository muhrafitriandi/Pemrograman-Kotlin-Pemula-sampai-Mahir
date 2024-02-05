package coroutine.kotlin.cancellable_coroutine

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CancellableCoroutineTest {
    fun performCriticalOperation(): String {
        // Simulasi operasi yang kritis atau penting
        Thread.sleep(5000) // just sample for case not cancellable, because with delay() can be cancellable
        return "Operasi Kritis Selesai"
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testNotCancellable() {
        runBlocking {
            val job = GlobalScope.launch {
                val result = performCriticalOperation()
                println(result)
            }
            job.cancel()
            job.join()

            println("Program selesai")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCancellable() {
        runBlocking {
            val job = GlobalScope.launch {
                if (!isActive) throw CancellationException()
                println("Status Coroutine ${Thread.currentThread().name}: $isActive")

                println("Status Coroutine ${Thread.currentThread().name}: $isActive")
                // if (!isActive) throw CancellationException() // manual
                ensureActive() // simple

                val result = performCriticalOperation()
                println(result)

                println("End Coroutine ${Thread.currentThread().name}")
            }
            job.cancel()
            job.join()
            println("Program selesai")
        }
    }
}