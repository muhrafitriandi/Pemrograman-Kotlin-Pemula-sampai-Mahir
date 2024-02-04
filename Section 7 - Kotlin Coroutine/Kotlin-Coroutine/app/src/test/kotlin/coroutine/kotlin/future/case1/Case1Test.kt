package coroutine.kotlin.future.case1

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

class Case1Test {
    val executor = Executors.newFixedThreadPool(3)
    val futures: MutableList<Future<Int>> = mutableListOf()

    @Test
    fun testProcess() {
        // Membuat beberapa task dan menjalankannya
        for (i in 1..5) {
            val task = Task(i)
            val future: Future<Int> = executor.submit(task)
            futures.add(future)
        }

        // Mengumpulkan hasil dari setiap task
        val results: MutableList<Int> = mutableListOf()
        for (future in futures) {
            try {
                val result = future.get() // Blocking call until the result is available
                results.add(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // Menutup Executor setelah selesai
        executor.shutdown()

        // Output hasil total
        val totalResult = results.sum()
        println("Total hasil dari pemrosesan paralel: $totalResult")
    }
}

// Kelas untuk memproses data di dalam thread
class Task(private val taskId: Int) : Callable<Int> {
    override fun call(): Int {
        // Proses data, misalnya menjumlahkan nilai dalam list
        val result = (1..10).random()

        // Menyimulasikan proses yang membutuhkan waktu
        Thread.sleep(1000)

        println("Task $taskId selesai memproses dengan hasil: $result")

        return result
    }
}