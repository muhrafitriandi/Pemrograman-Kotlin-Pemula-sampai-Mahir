package coroutine.kotlin.flow_exception.case1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class Case1Test {
    fun fetchDataFromServer(): Flow<String> = flow {
        repeat(3) {
            delay(1000)
            if (it == 2) throw Exception("Failed to fetch data")
            else emit("Data $it from server")
        }
    }

    @Test
    fun testFetchDataFromServer() {
        runBlocking {
            fetchDataFromServer()
                .onEach { println(it) }
                .catch { println("Error: ${it.message}") }
                .onCompletion { println("Process Done.") }
                .collect()
        }
    }
}