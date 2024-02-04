package coroutine.kotlin.pengenalan_coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.Date

class SuspendFunctionTest {
    suspend fun fetchDataFromNetwork(): String {
        println("Mengambil data dari jaringan... - ${Date()} ${Thread.currentThread().name}")
        delay(5000) // Simulasi operasi jaringan yang memakan waktu
        return "Data dari jaringan - ${Date()} ${Thread.currentThread().name}"
    }

    @Test
    fun testSuspendFunction() {
        runBlocking {
            println("Mulai eksekusi di thread utama")

            // Menjalankan fungsi suspend dari fungsi main
            val result = fetchDataFromNetwork()

            // Eksekusi berlanjut setelah fungsi suspend selesai
            println("Data berhasil diambil: $result")

            println("Eksekusi di thread utama selesai")
        }
    }
}