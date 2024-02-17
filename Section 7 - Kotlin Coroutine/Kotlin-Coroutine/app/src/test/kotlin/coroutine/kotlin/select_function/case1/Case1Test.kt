package coroutine.kotlin.select_function.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

class Case1Test {
    suspend fun fetchFromSource1(): String {
        delay(1000) // Meniru pengambilan data dari sumber pertama
        return "Data dari Sumber 1"
    }

    suspend fun fetchFromSource2(): String {
        delay(1500) // Meniru pengambilan data dari sumber kedua
        return "Data dari Sumber 2"
    }

    @Test
    fun testGetFastestData() {
        val scope = CoroutineScope(Dispatchers.IO)
        val deferred1 = scope.async { fetchFromSource1() }
        val deferred2 = scope.async { fetchFromSource2() }

        runBlocking {
            val fastestData = select {
                deferred1.onAwait { it }
                deferred2.onAwait { it }
            }
            println("Fastest Data: $fastestData")
        }
    }
}