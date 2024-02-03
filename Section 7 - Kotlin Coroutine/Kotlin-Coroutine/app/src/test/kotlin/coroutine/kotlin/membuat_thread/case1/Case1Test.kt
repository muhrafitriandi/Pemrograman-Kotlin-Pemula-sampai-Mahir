package coroutine.kotlin.membuat_thread.case1

import org.junit.jupiter.api.Test
import java.util.Date

class Case1Test {
    @Test
    fun testDownloadTask() {
        val imageUrl = "https://example.com/image.jpg"

        // Membuat objek Runnable untuk tugas yang akan dijalankan di dalam thread
        val downloadTask = DownloadTask(imageUrl)

        // Membuat thread dan menjalankan tugas di dalamnya
        val thread = Thread(downloadTask)
        thread.start()

        // Melanjutkan eksekusi di thread utama
        println("Aplikasi berjalan di thread utama.")

        // Menunggu hingga tugas selesai, kemudian mencetak pesan
        thread.join()
        println("Finish at: ${Date()}")
    }
}

class DownloadTask(private val url: String) : Runnable {
    override fun run() {
        // Proses pengunduhan gambar
        println("Mengunduh gambar dari $url")
        println("Running at: ${Date()}")
        Thread.sleep(2_000)
        val image = downloadImage(url)
        println("Gambar berhasil diunduh!")

        // Menyimpan gambar atau melakukan operasi lainnya
        saveImage(image)
    }

    private fun downloadImage(url: String): String {
        println("Mendownload gambar $url")
        return url
    }

    private fun saveImage(url: String) {
        // Simulasi penyimpanan gambar ke dalam sistem file atau database
        println("Menyimpan gambar $url")
    }
}
