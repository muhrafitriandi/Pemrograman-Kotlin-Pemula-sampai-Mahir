package coroutine.kotlin.supervisor_job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class SupervisorJobTest {
    @Test
    fun testWithoutSupervisorJob() {
        val scope = CoroutineScope(Dispatchers.IO + Job())
        val job1 = scope.launch {
            delay(1000)
            println("Start child 1 coroutine")
        }
        val job2 = scope.launch {
            delay(2000)
            throw IllegalArgumentException("Job 2 Failed")
            println("Start child 2 coroutine")
        }
        val job3 = scope.launch {
            delay(3000)
            println("Start child 3 coroutine")
        }

        runBlocking {
            joinAll(job1, job2, job3)
        }
    }

    @Test
    fun testWithSupervisorJob() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)
        val job1 = scope.launch {
            delay(1000)
            println("Start child 1 coroutine")
        }
        val job2 = scope.launch {
            delay(2000)
            throw IllegalArgumentException("Job 2 Failed")
            println("Start child 2 coroutine")
        }
        val job3 = scope.launch {
            delay(3000)
            println("Start child 3 coroutine")
        }

        runBlocking {
            joinAll(job1, job2, job3)
        }
    }
}