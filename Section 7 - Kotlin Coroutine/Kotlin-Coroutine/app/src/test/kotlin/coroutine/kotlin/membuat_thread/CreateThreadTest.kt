package coroutine.kotlin.membuat_thread

import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.concurrent.thread

class CreateThreadTest {
    @Test
    fun testCreateThread() {
        // Manual create thread:
//        val runnable = Runnable {
//            println(Date())
//            Thread.sleep(2_000)
//            println("Finish: ${Date()}")
//        }
//        val thread = Thread(runnable)
//        thread.start()

        // Simple create thread:
        thread {
            println(Date())
            Thread.sleep(2_000)
            println("Finish: ${Date()}")
        }

        println("Waiting.......")
        Thread.sleep(3_000)
        println(Date())
        println("Current thread ${Thread.currentThread().name} finish.")
    }
}