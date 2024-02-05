package coroutine.kotlin.setelah_coroutine_di_cancel

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.coroutines.coroutineContext

class AfterCoroutineCancelTest {
    suspend fun performTaskWithCleanup(): String {
        try {
            // Simulasi operasi yang dapat dibatalkan
            repeat(5) { i ->
                delay(1000)
                println("Iterasi ke-$i")
            }
            return "Operasi Selesai"
        } finally {
            // Tindakan pembersihan atau penanganan setelah pembatalan
            val isActiveDuringCancellation = coroutineContext.isActive
            println("Status Coroutine: $isActiveDuringCancellation. Lakukan tindakan pembersihan.")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCloseDatabase() {
        runBlocking {
            val job = GlobalScope.launch {
                val result = performTaskWithCleanup()
                println(result)
            }

            job.cancelAndJoin()
            println("Program selesai")
        }
    }
}