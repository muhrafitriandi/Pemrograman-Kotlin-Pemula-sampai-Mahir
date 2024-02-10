package coroutine.kotlin.exception_handling.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.io.IOException

class Case1Test {
    suspend fun fetchDataFromServer(): String {
        println("Fetching Data from Server...")
        delay(2000)
        // return "Rafi" // use this for success test case, will not get exception
        throw IOException("Network error occurred") // // use this for fail test case, will get exception
    }

    @Test
    fun testExceptionHandler() {
        // Membuat instance dari CoroutineExceptionHandler
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("Coroutine exception caught: ${exception.message}")
        }

        // Membuat coroutine scope dengan CoroutineExceptionHandler
        val scope = CoroutineScope(Job() + exceptionHandler)

        val job = scope.launch {
            val result = fetchDataFromServer()
            println("Data received: $result")
            println("Job running on: ${Thread.currentThread().name}")
        }

        runBlocking {
            job.join()
            println("End coroutine")
        }
    }
}