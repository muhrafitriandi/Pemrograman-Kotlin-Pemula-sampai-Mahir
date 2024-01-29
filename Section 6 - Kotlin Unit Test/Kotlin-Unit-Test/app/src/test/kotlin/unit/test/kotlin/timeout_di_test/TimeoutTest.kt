package unit.test.kotlin.timeout_di_test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

class TimeoutTest {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testSlow() {
        Thread.sleep(10_000)
        println("Do unit test slow")
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun testFast() {
        Thread.sleep(4_000)
        println("Do unit test fast")
    }
}