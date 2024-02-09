package coroutine.kotlin.coroutine_parent_child.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {
    // Fungsi untuk mengambil data dari server
    suspend fun fetchDataFromServer(): String {
        delay(2000) // Simulasi pengambilan data dari server
        return "Muhammad Rafi Triandi"
    }

    // Fungsi untuk melakukan perhitungan
    suspend fun performCalculation(data: String): Int {
        delay(1000) // Simulasi perhitungan
        return data.length // Misalnya, kita menghitung panjang data
    }

    // Fungsi untuk menyimpan data ke basis data lokal
    suspend fun saveDataToLocalDatabase(result: Int) {
        delay(1500) // Simulasi penyimpanan data ke basis data lokal
        println("Data berhasil disimpan ke basis data lokal dengan hasil: $result")
    }

    @Test
    fun testSequentialSaveData() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            // Child coroutine 1: Mengambil data dari server
            val dataFromServerDeferred = async {
                println("Child 1 Finish")
                fetchDataFromServer() // (menunggu selama 2 detik) hingga data server muncul
            }
            println("Data Child 1: ${dataFromServerDeferred.await()}")

            // Child coroutine 2: Melakukan perhitungan
            val calculatedResultDeferred = async {
                val dataFromServer = dataFromServerDeferred.await()
                println("Child 2 Finish")
                performCalculation(dataFromServer) // (menunggu selama 1 detik) setelah data server muncul
            }
            println("Data Child 2: ${calculatedResultDeferred.await()}")

            // Parent coroutine: Menyimpan data ke basis data lokal
            val result = calculatedResultDeferred.await()
            saveDataToLocalDatabase(result) // (menunggu selama 1,5 detik) setelah data calculated result muncul
            println("Parent Finish")
        }

        runBlocking {
            job.join()
        }
    }
}