package coroutine.kotlin.withContext_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class WithContextFunctionTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testWithContext() {
        runBlocking {
            println("1. Thread ${Thread.currentThread().name}")
            repeat(10) {
                GlobalScope.launch {
                    println("2. Thread ${Thread.currentThread().name}")
                    println(fetchDataFromNetwork())
                    println(fetchDataFromLocalDatabase())
                }
            }
            delay(5000)
            println("3. Thread ${Thread.currentThread().name}")
        }
    }

    suspend fun fetchDataFromNetwork(): String = withContext(Dispatchers.IO) {
        delay(2000)
        return@withContext "Data dari Server | ${Thread.currentThread().name}"
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    suspend fun fetchDataFromLocalDatabase(): String = withContext(newSingleThreadContext("Local DB")) {
        delay(2000)
        return@withContext "Data dari Local Database | ${Thread.currentThread().name}"
    }
}