package coroutine.kotlin.non_cancellable_coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class NonCancellableCoroutineTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testTimeOutWrongSuspendFinally() {
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
                    println("Job is active: ${coroutineContext.isActive}")
                    delay(1000)
                    println("Clean up database.")
                }
            }

            println("Waiting...")
            job.cancelAndJoin()
            println("Program Finished.")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testTimeOutRightSuspendFinally() {
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
                    withContext(NonCancellable) {
                        println("Job is active: ${coroutineContext.isActive}")
                        delay(1000)
                        println("Clean up database.")
                    }
                }
            }

            println("Waiting...")
            job.cancelAndJoin()
            println("Program Finished.")
        }
    }
}