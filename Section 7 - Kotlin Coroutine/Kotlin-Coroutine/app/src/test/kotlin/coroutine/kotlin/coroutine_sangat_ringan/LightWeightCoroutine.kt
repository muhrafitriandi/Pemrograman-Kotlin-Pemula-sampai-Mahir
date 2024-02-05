package coroutine.kotlin.coroutine_sangat_ringan

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class LightWeightCoroutine {
    @Test
    fun testThread() {
        val start = Date()
        val time = measureTimeMillis {
            repeat(100_000) {
                thread {
                    Thread.sleep(1000)
                    println("Thread ${Thread.currentThread().name} is running, iteration at-$it - ${Date()}")
                }
            }
        }

        println("Waiting...")
        Thread.sleep(2000)
        val end = Date()
        println("Finish from $start to $end")
        println("Total time: $time")
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testCoroutine() {
        val start = Date()
        val time = measureTimeMillis {
            repeat(100_000) {
                GlobalScope.launch {
                    delay(1000)
                    println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it - ${Date()}")
                }
            }
        }

        println("Waiting...")
        runBlocking { delay(2000) }
        val end = Date()
        println("Finish from $start to $end")
        println("Total time: $time")
    }
}