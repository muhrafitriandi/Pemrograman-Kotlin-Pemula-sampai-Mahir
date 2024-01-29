package unit.test.kotlin.eksekusi_test_secara_parallel

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit

@Execution(ExecutionMode.CONCURRENT)
class ParallelTest {
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