package coroutine.kotlin.membuat_coroutine

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.*

class CreateCoroutineTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCoroutineParallel() {
        println("Aplikasi dimulai ${Date()}")

        // Meluncurkan 20 coroutine secara parallel
        repeat(20) { count ->
            GlobalScope.launch {
                delay(1000)
                println("Coroutine ${Thread.currentThread().name} sedang berjalan, iterasi ke-$count")
            }
        }

        runBlocking { delay(2000) }

        println("Aplikasi selesai ${Date()}")
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCoroutineSequential() {
        println("Aplikasi dimulai ${Date()}")

        // Meluncurkan coroutine secara sequential di dalam GlobalScope
        GlobalScope.launch {
            repeat(5) { count ->
                delay(1000)
                println("Coroutine ${Thread.currentThread().name} sedang berjalan, iterasi ke-$count")
            }
        }

        runBlocking { delay(6000) }

        println("Aplikasi selesai ${Date()}")
    }
}