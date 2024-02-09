package coroutine.kotlin.coroutineScope_function.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutineScopeFunctionTest {

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    @Test
    fun testResult() {
        val time = measureTimeMillis {
            val scope = CoroutineScope(newSingleThreadContext("Sum Thread"))
            val job = scope.launch {
                println("Result: ${getResultSimple()}")
            }
            runBlocking {
                job.join()
            }
        }
        println("Total time: $time")
    }

    suspend fun getFoo(): Int {
        delay(1000)
        println("getFoo running on: ${Thread.currentThread().name}")
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        println("getBar running on: ${Thread.currentThread().name}")
        return 10
    }

    suspend fun getResultSimple(): Int = coroutineScope {
        val foo = async { getFoo() }
        val bar = async { getBar() }
        println("getResult running on: ${Thread.currentThread().name}")

        foo.await() + bar.await()
    }

    suspend fun getResultManual(): Int {
        val scope = CoroutineScope(Dispatchers.IO)
        val foo = scope.async { getFoo() }
        val bar = scope.async { getBar() }

        return foo.await() + bar.await()
    }
}