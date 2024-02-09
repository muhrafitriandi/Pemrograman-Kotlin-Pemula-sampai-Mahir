package coroutine.kotlin.coroutineScope_function.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    @Test
    fun testPerformTask() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            println(performTask())
        }
        runBlocking {
            job.join()
        }
    }

    suspend fun performTask(): String = coroutineScope {
        val result1 = async { fetchDataFromSource1() }
        val result2 = async { fetchDataFromSource2() }
        val result3 = async { performHeavyComputation() }

        return@coroutineScope "Result from Source 1: ${result1.await()}, " +
                "Result from Source 2: ${result2.await()}, " +
                "Result of Heavy Computation: ${result3.await()}"
    }

    suspend fun fetchDataFromSource1(): String {
        delay(1000)
        return "Pisang"
    }

    suspend fun fetchDataFromSource2(): String {
        delay(2000)
        return "Animal"
    }

    suspend fun performHeavyComputation(): Int {
        delay(3000)
        return 10
    }
}