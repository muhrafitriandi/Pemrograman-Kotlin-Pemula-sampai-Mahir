package coroutine.kotlin.exception_handling

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.io.IOException

class ExceptionHandlingTest {

    suspend fun fetchDataFromServer(): String {
        println("Fetching Data from Server...")
        delay(2000)
        throw IOException("Network error occurred")
    }

    @Test
    fun testExceptionLaunchManual() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            try {
                fetchDataFromServer()
            } catch (e: IOException) {
                println("Coroutine exception caught: ${e.message}")
            } finally {
                println("End coroutine")
            }
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testExceptionLaunchSimple() {
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("Coroutine exception caught: $exception")
        }
        val scope = CoroutineScope(Dispatchers.IO + exceptionHandler)
        val job = scope.launch {
            fetchDataFromServer()
        }

        runBlocking {
            job.join()
            println("End coroutine")
        }
    }

    @Test
    fun testExceptionAsyncManual() { // Specifically for the async() function, you cannot use CoroutineExceptionHandler, you have to create a try-catch manually.
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.async {
            fetchDataFromServer()
        }

        runBlocking {
            try {
                val result = job.await()
                println("Async task result: $result")
            } catch (e: IOException) {
                println("Coroutine exception caught: ${e.message}")
            } finally {
                println("End coroutine")
            }
        }
    }
}