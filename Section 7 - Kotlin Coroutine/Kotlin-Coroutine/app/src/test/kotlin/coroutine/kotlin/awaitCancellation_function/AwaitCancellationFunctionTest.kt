package coroutine.kotlin.awaitCancellation_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class AwaitCancellationFunctionTest {
    @Test
    fun testAwaitCancellation() {
        runBlocking {
            val job = launch {
                try {
                    println("Job Start")
                    awaitCancellation() // Coroutine will suspend and wait for cancellation
                } finally {
                    println("Job End") // This block will execute after cancellation
                }
            }
            delay(5000) // Wait for 5 seconds before cancelling the job
            // job.join() // Coroutine will never stop, because it waits for the job to complete normally
            job.cancelAndJoin() // Using cancelAndJoin() will cancel the job and wait for its completion
        }
    }
}