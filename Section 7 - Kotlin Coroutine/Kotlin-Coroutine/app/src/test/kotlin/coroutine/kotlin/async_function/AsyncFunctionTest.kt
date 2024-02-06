package coroutine.kotlin.async_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AsyncFunctionTest {
    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testAsyncFunction() {
        runBlocking {
            val time = measureTimeMillis {
                val foo: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar: Deferred<Int> = GlobalScope.async { getBar() }

                val result = foo.await() + bar.await()
                println("Result: $result")
            }
            println("Total time: $time")
        }
    }
}