package coroutine.kotlin.job

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class JobTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testRunBlockingWithoutBlocking() {
        runBlocking {
            repeat(20) {
                GlobalScope.launch {
                    delay(1000)
                    println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it")
                }
            }
        }
    }

    @Test
    fun testRunBlockingWithBlocking() {
        runBlocking {
            repeat(20) {
                delay(1000)
                println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it")
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testJobStartManual() {
        runBlocking {
            repeat(20) {
                val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                    delay(1000)
                    println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it")
                }
                job.start() // Memulai eksekusi job secara manual
            }
            println("Waiting...")
            delay(2000)
            println("Finish")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testJobJoin() {
        var job: Job = Job()

        runBlocking {
            repeat(20) {
                job = GlobalScope.launch {
                    delay(1000)
                    println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it")
                }
            }
            println("Waiting...")
            job.join()
            println("Finish")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testJobCancel() {
        var job: Job = Job()

        runBlocking {
            repeat(20) {
                job = GlobalScope.launch {
                    delay(1000)
                    println("Coroutine ${Thread.currentThread().name} is running, iteration at-$it")
                }
            }
            println("Waiting...")
            job.cancel()
            job.join()
            println("Finish")
        }
    }
}