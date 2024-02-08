package coroutine.kotlin.non_cancellable_coroutine.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    suspend fun saveDataToDatabase(data: String): String = coroutineScope {
        // Lakukan operasi I/O seperti menyimpan data ke basis data lokal
        withContext(Dispatchers.IO) {
            // Simulasi operasi penyimpanan data
            delay(2000)
            // Mengembalikan hasil operasi
            return@withContext "Data '$data' berhasil disimpan ke basis data lokal."
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCancellable() {
        runBlocking {
            val job = GlobalScope.launch {
                try {
                    // Melakukan operasi penyimpanan data ke basis data lokal
                    val result = saveDataToDatabase("Contoh data")
                    println(result)
                } finally {
                    // Tetap melanjutkan operasi bahkan jika coroutine dibatalkan
                    withContext(NonCancellable) {
                        println("Operasi Non Cancellable selesai.")
                    }
                }
            }
            job.cancelAndJoin()
        }
    }
}