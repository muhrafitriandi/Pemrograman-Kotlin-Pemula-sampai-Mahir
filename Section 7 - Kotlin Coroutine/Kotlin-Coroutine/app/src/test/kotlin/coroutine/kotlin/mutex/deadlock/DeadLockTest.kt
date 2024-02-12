package coroutine.kotlin.mutex.deadlock

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test

class DeadLockTest {
    val mutex1 = Mutex()
    val mutex2 = Mutex()

    @Test
    fun problemDeadlock() = runBlocking {
        val job1 = launch {
            mutex1.withLock {
                delay(100)
                mutex2.withLock {
                    println("Job 1 completed")
                }
            }
        }

        val job2 = launch {
            mutex2.withLock {
                delay(100)
                mutex1.withLock {
                    println("Job 2 completed")
                }
            }
        }

        joinAll(job1, job2)
    }

    @Test
    fun handlingDeadlock() = runBlocking {
        val job1 = launch {
            mutex1.withLock {
                delay(100)
                withTimeoutOrNull(1000) {
                    mutex2.withLock {
                        println("Job 1 completed")
                    }
                }
            }
        }

        val job2 = launch {
            mutex2.withLock {
                delay(100)
                withTimeoutOrNull(1000) {
                    mutex1.withLock {
                        println("Job 2 completed")
                    }
                }
            }
        }

        joinAll(job1, job2)
    }
}