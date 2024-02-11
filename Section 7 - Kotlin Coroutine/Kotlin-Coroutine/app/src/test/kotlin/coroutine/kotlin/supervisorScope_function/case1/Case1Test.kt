package coroutine.kotlin.supervisorScope_function.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    @Test
    fun testAsyncSupervisorScopeFunction() {
        val scope = CoroutineScope(Dispatchers.IO + Job())
        val job = scope.launch {
            println(getResult())
        }

        runBlocking {
            job.join()
        }
    }

    suspend fun fetchData1FromServer(): String {
        delay(1000)
        println("Data 1 Success")
        return "Data 1"
    }

    suspend fun fetchData2FromServer(): String {
        delay(2000)
        throw IllegalArgumentException("Fetch data 2 failed")
        return "Data 2"
    }

    suspend fun fetchData3FromServer(): String {
        delay(3000)
        println("Data 3 Success")
        return "Data 3"
    }

    suspend fun getResult(): List<String> = supervisorScope {
        val data1Deferred = async { fetchData1FromServer() }
        val data2Deferred = async { fetchData2FromServer() }
        val data3Deferred = async { fetchData3FromServer() }

        val result = mutableListOf<String>()

        try {
            result.add(data1Deferred.await())
        } catch (e: IllegalArgumentException) {
            println("Fetch data 1 failed: ${e.message}")
        }

        try {
            result.add(data2Deferred.await())
        } catch (e: IllegalArgumentException) {
            println("Fetch data 2 failed: ${e.message}")
        }

        try {
            result.add(data3Deferred.await())
        } catch (e: IllegalArgumentException) {
            println("Fetch data 3 failed: ${e.message}")
        }

        result
    }
}