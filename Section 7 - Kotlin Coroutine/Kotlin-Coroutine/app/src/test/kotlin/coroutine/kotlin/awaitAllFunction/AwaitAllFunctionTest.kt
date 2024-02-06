package coroutine.kotlin.awaitAllFunction

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AwaitAllFunctionTest {
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
    fun testAwaitAllFunction() {
        runBlocking {
            val time = measureTimeMillis {
                val foo: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar: Deferred<Int> = GlobalScope.async { getBar() }

                val result: List<Int> = awaitAll(foo, bar)
                println("Result: ${result.sum()}")
            }
            println("Total time: $time")
        }
    }
}