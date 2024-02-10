package coroutine.kotlin.yield_function.case1

import kotlinx.coroutines.*
import kotlin.test.Test

class Case1Test {

    @Test
    fun testCase1() {
        runBlocking {
            val job1 = launch {
                repeat(10) {
                    println("$it. step done in job 1 ")
                    yield() // without this, job1 will execute sequentially
                }
            }

            val job2 = launch {
                repeat(10) {
                    println("$it. step done in job 2 ")
                    yield() // without this, job2 will execute sequentially, before job 1 done
                }
            }

            joinAll(job1, job2)
            println("done")
        }
    }

    @Test
    fun testCase2() {
        runBlocking {
            val job = launch {
                val child = launch {
                    try {
                        println("Child is running")
                        delay(1000)
                    } finally {
                        println("Child is cancelled")
                    }
                }

                yield() // without this, child job doesn't get executed
                child.cancelAndJoin()
                println("Parent is not cancelled")
            }
            println("Parent is running")
            job.join()
        }
    }
}
