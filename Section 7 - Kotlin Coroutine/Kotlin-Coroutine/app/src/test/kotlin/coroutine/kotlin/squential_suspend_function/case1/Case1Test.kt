package coroutine.kotlin.squential_suspend_function.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class Case1Test {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testSuspendSequentialCoroutine() {
        val yNumbers = mutableListOf<Int>()
        val xNumbers = mutableListOf<Int>()

        runBlocking {
            val time = measureTimeMillis {
                val jobX = GlobalScope.launch {
                    repeat(5) {
                        val number = processNumber()
                        xNumbers.add(number)
                        println("Process Number X: $number")
                        println("Running Job X on coroutine ${Thread.currentThread().name}")
                    }
                }

                val jobY = GlobalScope.launch {
                    repeat(5) {
                        val number = processNumber()
                        yNumbers.add(number)
                        println("Process Number Y: $number")
                        println("Running Job Y on coroutine ${Thread.currentThread().name}")
                    }
                }
                joinAll(jobX, jobY)
            }
            println("X Numbers: $xNumbers, Total: ${xNumbers.sum()}")
            println("Y Numbers: $yNumbers, Total: ${yNumbers.sum()}")
            println("Total X(${xNumbers.sum()}) + Y(${yNumbers.sum()}) Numbers: ${xNumbers.sum() + yNumbers.sum()}")
            println("Total time: $time")
        }
    }

    suspend fun processNumber(): Int {
        delay(1000)
        return (1..10).random()
    }
}