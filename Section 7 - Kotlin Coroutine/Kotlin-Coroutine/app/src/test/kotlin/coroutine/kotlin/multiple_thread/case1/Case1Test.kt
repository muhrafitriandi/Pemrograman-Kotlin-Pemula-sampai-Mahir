package coroutine.kotlin.multiple_thread.case1

import org.junit.jupiter.api.Test
import kotlin.concurrent.thread
import kotlin.random.Random

class Case1Test {

    @Test
    fun testDataProcessing() {
        val data = generateData(10)

        // Membagi data menjadi dua bagian
        val halfSize = data.size / 2
        val part1 = data.slice(0 until halfSize)
        val part2 = data.slice(halfSize until data.size)

        // Membuat dua thread untuk memproses dua bagian data secara paralel
        val thread1 = thread { processPart(part1) }
        val thread2 = thread { processPart(part2) }

        // Menunggu kedua thread selesai
        thread1.join()
        thread2.join()

        // Menggabungkan hasil dari dua thread
        val result = mergeResults(part1, part2)
        println("Hasil akhir: $result")
    }

    fun generateData(size: Int): List<Int> {
        return List(size) { Random.nextInt(1, 100) }
    }

    fun processPart(part: List<Int>): List<Int> {
        println("Thread ${Thread.currentThread().name} sedang memproses bagian data: $part")
        Thread.sleep(2_000)
        return part
    }

    fun mergeResults(part1: List<Int>, part2: List<Int>): List<Int> {
        println("Sedang melakukan merge...")
        Thread.sleep(3_000)
        println("Transform Part 1: ${part1.map { it * 2 }}")
        println("Transform Part 2: ${part2.map { it * 2 }}")
        // Menggabungkan hasil dari dua thread
        return (part1 + part2).map { it * 2 }
    }
}