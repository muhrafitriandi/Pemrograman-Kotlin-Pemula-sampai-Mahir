package coroutine.kotlin.yield_function

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class YieldFunctionTest {
    suspend fun runJob(range: Int) {
        println("Start job $range : ${Thread.currentThread().name}")
        yield()
        println("End job $range : ${Thread.currentThread().name}")
    }

    @Test
    fun testYieldFunction() {
        val scope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())

        runBlocking {
            scope.launch {
                runJob(1)
            }
            scope.launch {
                runJob(2)
            }
            delay(2000)
        }
    }
}