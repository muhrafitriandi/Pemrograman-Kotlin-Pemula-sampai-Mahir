package coroutine.kotlin.withContext_function.case1

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test

class Case1Test {
    // Fungsi untuk mengambil data pengguna dari server
    suspend fun fetchUserData(): String = withContext(Dispatchers.IO) {
        // Lakukan operasi I/O seperti mengambil data dari server
        delay(2000) // Delay simulasi
        return@withContext "Data pengguna dari server"
    }

    // Fungsi untuk menampilkan data pengguna di antarmuka pengguna (UI)
//    suspend fun displayUserData(userData: String) = withContext(Dispatchers.Main) {
//        // Lakukan operasi yang memengaruhi UI di thread utama
//        println("Data pengguna: $userData")
//    }

    @Test
    fun testFetchDataAndDisplay() {
        runBlocking {
            val userData = fetchUserData() // Lakukan pengambilan data pengguna secara asinkron
//            displayUserData(userData) // Menampilkan data pengguna di antarmuka pengguna (UI)
            println(userData)
        }
    }
}