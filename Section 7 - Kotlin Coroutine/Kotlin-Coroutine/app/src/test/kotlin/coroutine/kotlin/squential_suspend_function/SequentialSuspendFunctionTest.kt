package coroutine.kotlin.squential_suspend_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class SequentialSuspendFunctionTest {
    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @Test
    fun testSuspendSequential() {
        runBlocking {
            val time = measureTimeMillis {
                getFoo()
                getBar()
            }
            println("Running on coroutine ${Thread.currentThread().name}")
            println("Total time: $time")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testSuspendSequentialCoroutine() {
        runBlocking {
            val time = measureTimeMillis {
                val job = GlobalScope.launch {
                    getFoo()
                    getBar()
                }
                job.join()
            }
            println("Running on coroutine ${Thread.currentThread().name}")
            println("Total time: $time")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testSuspendConcurrentCoroutine() {
        runBlocking {
            val time = measureTimeMillis {
                val foo = GlobalScope.launch {
                    println("Running getBar() on coroutine ${Thread.currentThread().name}")
                    getFoo()
                }
                val bar = GlobalScope.launch {
                    println("Running getBar() on coroutine ${Thread.currentThread().name}")
                    getBar()
                }
                joinAll(foo, bar)
            }
            println("Total time: $time")
        }
    }
}