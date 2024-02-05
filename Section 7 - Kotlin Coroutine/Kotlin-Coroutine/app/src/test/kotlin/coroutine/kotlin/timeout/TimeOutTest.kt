package coroutine.kotlin.timeout

import kotlinx.coroutines.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TimeOutTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    @DisplayName("After coroutine timeout or fail, they're return throw `TimeoutCancellationException and not clean up the database")
    fun testTimeOut() {
        runBlocking {
            val job = GlobalScope.launch {
                withTimeout(5000) {
                    repeat(10) {
                        delay(1000)
                        println("Iteration at-$it ${Thread.currentThread().name}")
                    }
                }
                println("Clean up database.")
            }

            println("Waiting...")
            job.join()
            println("Program Finished.")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    @DisplayName("After coroutine timeout or fail/success, they're return throw `TimeoutCancellationException and clean up the database")
    fun testTimeOutWithFinally() {
        runBlocking {
            val job = GlobalScope.launch {
                try {
                    withTimeout(5000) {
                        repeat(10) {
                            delay(1000)
                            println("Iteration at-$it ${Thread.currentThread().name}")
                        }
                    }
                } finally {
                    println("Clean up database.")
                }
            }

            println("Waiting...")
            job.join()
            println("Program Finished.")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    @DisplayName("After coroutine timeout or fail/success, they're return null and clean up the database")
    fun testTimeOutWithNull() {
        runBlocking {
            val job = GlobalScope.launch {
                withTimeoutOrNull(5000) {
                    repeat(10) {
                        delay(1000)
                        println("Iteration at-$it ${Thread.currentThread().name}")
                    }
                }
                println("Clean up database.")
            }

            println("Waiting...")
            job.join()
            println("Program Finished.")
        }
    }
}