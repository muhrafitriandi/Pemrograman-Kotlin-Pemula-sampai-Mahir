package coroutine.kotlin

import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun testThreadName() {
        val threadName = Thread.currentThread().name
        println("Running in thread $threadName")
    }
}