package coroutine.kotlin.mutex

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test

class MutexTest {
    @Test
    fun testProblemMutex() {
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch {
            counterWithMutex()
//            counterWithoutMutex()
        }

        runBlocking {
            job.join()
        }
    }

    suspend fun counterWithMutex() = coroutineScope {
        var counter = 0
        val mutex = Mutex()

        repeat(100) {
            launch {
                repeat(1000) {
                    mutex.withLock {
                        counter++
                    }
                }
            }
        }

        delay(1000)
        println("Total counter: $counter")
    }

    suspend fun counterWithoutMutex() = coroutineScope {
        var counter = 0

        repeat(100) {
            launch {
                repeat(1000) {
                    counter++
                }
            }
        }

        delay(1000)
        println("Total counter: $counter")
    }
}