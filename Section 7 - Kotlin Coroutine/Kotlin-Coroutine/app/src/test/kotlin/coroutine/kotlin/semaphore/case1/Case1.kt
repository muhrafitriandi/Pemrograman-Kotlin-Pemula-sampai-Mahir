package coroutine.kotlin.semaphore.case1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import org.junit.jupiter.api.Test

class Case1 {

    val semaphore = Semaphore(permits = 4)

    @Test
    fun testExecuteRequest() {
        val requests = listOf(
            "Request 1",
            "Request 2",
            "Request 3",
            "Request 4",
            "Request 5",
            "Request 6",
            "Request 7",
            "Request 8",
            "Request 9",
            "Request 10"
        )

        runBlocking {
            requests.forEach { request ->
                launch {
                    executeRequest(request)
                }
            }
        }
    }

    suspend fun executeRequest(request: String) {
        semaphore.withPermit {
            println("Executing $request")
            delay(1000) // Simulate API call
            println("Finished $request")
        }
    }
}