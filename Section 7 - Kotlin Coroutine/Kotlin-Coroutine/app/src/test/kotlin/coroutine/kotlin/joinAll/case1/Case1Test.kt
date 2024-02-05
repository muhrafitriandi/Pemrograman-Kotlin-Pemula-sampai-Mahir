package coroutine.kotlin.joinAll.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    suspend fun fetchDataFromSource(source: String): String {
        // Simulasi pengambilan data dari sumber
        delay((1..3).random() * 1000L)
        return "Data from $source"
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testFetchData() {
        runBlocking {
            val sources = listOf("SourceA", "SourceB", "SourceC")

            val jobs = mutableListOf<Job>()

            for (source in sources) {
                val job = GlobalScope.launch {
                    val data = fetchDataFromSource(source)
                    println("Data received: $data from $source | ${Thread.currentThread().name}")
                }
                jobs.add(job)
            }

            // Menggunakan joinAll untuk menunggu penyelesaian semua pekerjaan koroutine
            jobs.joinAll()

            println("Semua pekerjaan selesai. Lanjutkan ke langkah berikutnya.")
        }
    }
}