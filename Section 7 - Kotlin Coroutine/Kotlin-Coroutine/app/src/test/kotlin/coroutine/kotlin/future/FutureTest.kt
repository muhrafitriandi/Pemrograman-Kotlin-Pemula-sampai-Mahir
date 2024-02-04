package coroutine.kotlin.future

import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.system.measureTimeMillis

class FutureTest {
    val executors = Executors.newFixedThreadPool(3)

    fun getFoo(): Int {
        Thread.sleep(1000)
        return 10
    }

    fun getBar(): Int {
        Thread.sleep(1000)
        return 10
    }

    @Test
    fun testSequential() {
        val time = measureTimeMillis {
            val result = getFoo() + getBar()
            println("Result: $result")
        }
        println("Total time: $time")
    }

    @Test
    fun testParallel() {
        val time = measureTimeMillis {
            val foo: Future<Int> = executors.submit(Callable { getFoo() })
            val bar: Future<Int> = executors.submit(Callable { getBar() })
            val result = foo.get() + bar.get() // Blocking call until the result is available
            println("Result: $result")
        }
        println("Total time: $time")
    }
}