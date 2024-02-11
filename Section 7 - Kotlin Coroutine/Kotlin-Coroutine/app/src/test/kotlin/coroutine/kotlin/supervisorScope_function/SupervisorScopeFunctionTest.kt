package coroutine.kotlin.supervisorScope_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class SupervisorScopeFunctionTest {
    @Test
    fun testSupervisorScopeFunction() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO + exceptionHandler + Job())

        val job = scope.launch {
            println("Parent running on: ${Thread.currentThread().name}")

            supervisorScope {
                launch {
                    delay(1000)
                    println("Child 1 running on: ${Thread.currentThread().name}")
                }
                launch {
                    delay(2000)
                    throw IllegalArgumentException("Job 2 failed")
                    println("Child 2 running on: ${Thread.currentThread().name}")
                }
                launch {
                    delay(3000)
                    println("Child 3 running on: ${Thread.currentThread().name}")
                }
            }
        }

        runBlocking {
            job.join()
        }
    }
}