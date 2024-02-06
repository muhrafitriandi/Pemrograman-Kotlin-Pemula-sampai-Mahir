package coroutine.kotlin.async_function.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Case1Test {
    // Fungsi untuk mengambil informasi pengguna dari server
    suspend fun fetchUserData(): String {
        delay(2000) // Delay simulasi untuk menyimulasikan jaringan
        return "Informasi pengguna dari server"
    }

    // Fungsi untuk mengambil daftar teman dari basis data lokal
    suspend fun fetchFriendList(): List<String> {
        delay(1500) // Delay simulasi untuk menyimulasikan pembacaan dari basis data lokal
        return listOf("Teman 1", "Teman 2", "Teman 3")
    }

    // Fungsi untuk mengambil informasi tambahan dari API eksternal
    suspend fun fetchAdditionalInfo(): String {
        delay(3000) // Delay simulasi untuk menyimulasikan koneksi jaringan
        return "Informasi tambahan dari API eksternal"
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testGetMultipleApiAsync() {
        runBlocking {
            val time = measureTimeMillis {
                val userData = GlobalScope.async { fetchUserData() }
                val friendList: Deferred<List<String>> = GlobalScope.async { fetchFriendList() }
                val additionalInfo: Deferred<String> = GlobalScope.async { fetchAdditionalInfo() }

                // Menunggu semua deferred untuk selesai
                println("""
                    User Data: ${userData.await()}
                    Friend List: ${friendList.await()}
                    Additional Info: ${additionalInfo.await()}
                """.trimIndent())
            }
            println("Total time: $time")
        }
    }
}