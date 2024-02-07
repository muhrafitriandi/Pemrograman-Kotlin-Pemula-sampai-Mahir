package coroutine.kotlin.coroutine_context

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutineContextTest {
    @OptIn(DelicateCoroutinesApi::class, ExperimentalStdlibApi::class)
    @Test
    fun testCoroutineContext() {
        runBlocking {
            val time = measureTimeMillis {
                val job = GlobalScope.launch {
                    delay(3000)
                    coroutineContext[Job]?.cancel()
                    println(coroutineContext)
                    println("Job is Active: ${coroutineContext[Job]?.isActive}")
                    println("Job: ${coroutineContext[Job]}")
                    println("Dispatcher: ${coroutineContext[CoroutineDispatcher]}")
                }
                job.join()
            }
            println("Total time: $time")
        }
    }
}