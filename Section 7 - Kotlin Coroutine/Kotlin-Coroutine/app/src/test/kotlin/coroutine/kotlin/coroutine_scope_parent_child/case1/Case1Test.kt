package coroutine.kotlin.coroutine_scope_parent_child.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    // Fungsi untuk melakukan pencarian data dari sumber tertentu
    suspend fun searchData(source: String): String {
        return withContext(Dispatchers.IO) {
            // Lakukan operasi pencarian data dari sumber tertentu
            println("searchData running on: ${Thread.currentThread().name}")
            delay(2000) // Simulasi operasi I/O
            return@withContext "Data dari $source"
        }
    }

    // Fungsi untuk melakukan pencarian data dari semua sumber secara bersamaan
    suspend fun searchAllData(): List<String> = coroutineScope {
        val sourceList = listOf("Sumber 1", "Sumber 2", "Sumber 3")

        val deferredResults = mutableListOf<Deferred<String>>()
        for (source in sourceList) {
            val deferred = async {
                searchData(source)
            }
            deferredResults.add(deferred)
        }

        val results = deferredResults.map { it.await() }
        println("searchAllData running on: ${Thread.currentThread().name}")
        return@coroutineScope results
    }

    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    @Test
    fun testSearchData() {
        val scope = CoroutineScope(newSingleThreadContext("Banana Thread"))
        val job = scope.launch {
            val results = searchAllData()
            results.forEach { result ->
                println("Hasil pencarian: $result")
            }
        }

        runBlocking {
            job.join()
        }
    }
}