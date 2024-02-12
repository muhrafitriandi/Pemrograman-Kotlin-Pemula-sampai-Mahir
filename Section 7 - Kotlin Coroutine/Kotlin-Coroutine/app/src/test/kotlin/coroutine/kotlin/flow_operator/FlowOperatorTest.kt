package coroutine.kotlin.flow_operator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowOperatorTest {

    fun flowNumber(): Flow<Int> = flow {
        repeat(100) {
            emit(it)
        }
    }

    suspend fun transformNumber(number: Int): String {
        delay(100)
        return "Number $number"
    }

    @Test
    fun testTransformFlowNumber() {
        runBlocking {
            flowNumber()
                .filter { it % 2 == 0 }
                .map { transformNumber(it) }
                .collect {
                    println(it)
                }
        }
    }
}