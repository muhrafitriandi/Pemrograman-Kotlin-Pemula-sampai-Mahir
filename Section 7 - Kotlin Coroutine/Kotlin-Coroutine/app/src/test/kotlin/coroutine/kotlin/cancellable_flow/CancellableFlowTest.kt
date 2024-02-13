package coroutine.kotlin.cancellable_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.junit.jupiter.api.Test

class CancellableFlowTest {
    fun flowNumber(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    @Test
    fun testCancellableFlow() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            flowNumber()
                .onEach {
                    if (it > 10) cancel()
                    else println("Number $it running on ${Thread.currentThread().name}")
                }
                .collect()
        }

        runBlocking {
            job.join()
        }
    }
}