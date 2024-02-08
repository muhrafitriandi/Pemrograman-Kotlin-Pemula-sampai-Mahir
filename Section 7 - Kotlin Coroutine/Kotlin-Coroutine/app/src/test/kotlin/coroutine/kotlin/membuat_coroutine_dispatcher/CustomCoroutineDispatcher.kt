package coroutine.kotlin.membuat_coroutine_dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class CustomCoroutineDispatcher {
    private val webDispatcher = Executors.newFixedThreadPool(3).asCoroutineDispatcher()
    private val mobileDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCustomDispatcherExecutorService() {
        runBlocking {
            println("runBlocking Running on thread: ${Thread.currentThread().name}")
            repeat(5) {
                GlobalScope.launch(webDispatcher) {
                    println("$it Web Running on thread: ${Thread.currentThread().name}")
                }

                GlobalScope.launch(mobileDispatcher) {
                    println("$it Mobile Running on thread: ${Thread.currentThread().name}")
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
    @Test
    fun testCustomDispatcherSingleThreadContext() {
        runBlocking {
            println("runBlocking Running on thread: ${Thread.currentThread().name}")
            repeat(5) {
                GlobalScope.launch(newSingleThreadContext("IOThread")) {
                    val userData = fetchUserData()
                    println("User Data: $userData - ${Thread.currentThread().name}")
                }
            }
            delay(3000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCustomDispatcherFixedThreadPoolContext() {
        runBlocking {
            println("runBlocking Running on thread: ${Thread.currentThread().name}")
            GlobalScope.launch(newFixedThreadPoolContext(4, "ComputationThread")) {
                val computationResult = performComputation()
                println("Thread testCustomDispatcherFixedThreadPoolContext(): ${Thread.currentThread().name}")
                println("Computation Result: $computationResult")
            }
            delay(2000)
        }
    }

    suspend fun fetchUserData(): String = withContext(Dispatchers.IO) {
        // Lakukan operasi I/O seperti mengambil data dari server
        delay(2000)
        return@withContext "Data pengguna dari server - ${Thread.currentThread().name}"
    }

    suspend fun performComputation(): Int = withContext(Dispatchers.Default) {
        // Lakukan operasi komputasi yang intensif
        var result = 0
        for (i in 1..1000000) {
            result += i
        }
        println("Thread performComputation(): ${Thread.currentThread().name}")
        return@withContext result
    }
}