package coroutine.kotlin.exception_handler_supervisor_job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class ExceptionHandlerSupervisorJobTest {
    @Test
    fun testWrongExceptionHandler() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch {
            println("Parent running on: ${Thread.currentThread().name}")

            launch(exceptionHandler) { // error, exception will extend/propagate to parent
                println("Child running on: ${Thread.currentThread().name}")
                throw IllegalArgumentException("Child error")
            }
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testWrongExceptionHandlerSupervisorScope() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch {
            println("Parent running on: ${Thread.currentThread().name}")

            supervisorScope {
                launch {
                    println("Semi-parent running on: ${Thread.currentThread().name}")

                    launch(exceptionHandler) { // error, exception will extend/propagate to semi-parent
                        println("Child running on: ${Thread.currentThread().name}")
                        throw IllegalArgumentException("Child error")
                    }
                }
            }
        }

        runBlocking {
            job.join()
        }
    }


    @Test
    fun testRightExceptionHandler() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch(exceptionHandler) { // exception handler must be at least in parent coroutine context
            println("Parent running on: ${Thread.currentThread().name}")

            launch {
                println("Child running on: ${Thread.currentThread().name}")
                throw IllegalArgumentException("Child error")
            }
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun testRightExceptionHandlerSupervisorScope() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            println("Error: ${throwable.message}")
        }
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch {
            println("Parent running on: ${Thread.currentThread().name}")

            supervisorScope {
                launch(exceptionHandler) { // exception handler must be at least in semi-parent coroutine context when using supervisorScope
                    println("Semi-parent running on: ${Thread.currentThread().name}")

                    launch {
                        println("Child running on: ${Thread.currentThread().name}")
                        throw IllegalArgumentException("Child error")
                    }
                }
            }
        }

        runBlocking {
            job.join()
        }
    }
}