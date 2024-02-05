package coroutine.kotlin.joinAll

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class JoinAllTest {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testJoinAll() {
        runBlocking {
            val job1: Job = GlobalScope.launch {
                delay(2000)
                println("Job 1 with Coroutine ${Thread.currentThread().name}")
            }

            val job2: Job = GlobalScope.launch {
                delay(10_000)
                println("Job 2 with Coroutine ${Thread.currentThread().name}")
            }

            joinAll(job1, job2)
        }
    }
}