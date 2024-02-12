package coroutine.kotlin.semaphore

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import org.junit.jupiter.api.Test

class SemaphoreTest {

    @Test
    fun testSemaphore() {
        var counter = 0
        val semaphore = Semaphore(permits = 2)
        val scope = CoroutineScope(Dispatchers.IO)

        runBlocking {
            repeat(100) {
                scope.launch {
                    repeat(1000) {
                        semaphore.withPermit {
                            counter++
                        }
                    }
                }
            }
            delay(1000)
            println("Total counter: $counter")
        }
    }
}