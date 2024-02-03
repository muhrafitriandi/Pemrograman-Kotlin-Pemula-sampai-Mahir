package coroutine.kotlin.multiple_thread

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.concurrent.thread

class MultipleThreadTest {
    @Test
    fun testMultipleThread() {
        thread {
            println(Date())
            Thread.sleep(2_000)
            println("Finish thread 1 - ${Thread.currentThread().name} - ${Date()}")
        }

        thread {
            println(Date())
            Thread.sleep(2_000)
            println("Finish thread 2 - ${Thread.currentThread().name} - ${Date()}")
        }

        println("Waiting.......")
        Thread.sleep(3_000)
        println(Date())
        println("Current thread ${Thread.currentThread().name} finish.")
    }
}