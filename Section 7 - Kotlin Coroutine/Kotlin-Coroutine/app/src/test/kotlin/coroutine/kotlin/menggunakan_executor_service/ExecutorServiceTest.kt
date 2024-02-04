package coroutine.kotlin.menggunakan_executor_service

import org.junit.jupiter.api.Test
import java.util.Date
import java.util.concurrent.Executors

class ExecutorServiceTest {
    @Test
    fun testSingleThread() {
        val singleThreadExecutor = Executors.newSingleThreadExecutor()
        repeat(10) {
            singleThreadExecutor.execute {
                Thread.sleep(1_000)
                println("Running $it on thread ${Thread.currentThread().name} - ${Date()}")
            }
            println("Entering queue $it into${Thread.currentThread().name}")
        }
        println("Waiting....")
        Thread.sleep(11_000)
        println("Done.")
    }

    @Test
    fun testFixedThread() {
        val fixedThreadPool = Executors.newFixedThreadPool(3)
        repeat(10) {
            fixedThreadPool.execute {
                Thread.sleep(1_000)
                println("Running $it on thread ${Thread.currentThread().name} - ${Date()}")
            }
            println("Entering queue $it into${Thread.currentThread().name}")
        }
        println("Waiting....")
        Thread.sleep(11_000)
        println("Done.")
    }

    @Test
    fun testCachedThread() {
        val cachedThreadPool = Executors.newCachedThreadPool()
        repeat(10) {
            cachedThreadPool.execute {
                Thread.sleep(1_000)
                println("Running $it on thread ${Thread.currentThread().name} - ${Date()}")
            }
            println("Entering queue $it into${Thread.currentThread().name}")
        }
        println("Waiting....")
        Thread.sleep(11_000)
        println("Done.")
    }
}