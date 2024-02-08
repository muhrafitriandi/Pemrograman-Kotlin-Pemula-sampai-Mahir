package coroutine.kotlin.coroutine_scope

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineScopeTest {
    @Test
    fun testCoroutineScopeSpecificJobCancellable() {
        runBlocking {
            val scope = CoroutineScope(Dispatchers.IO)

            val job1 = scope.launch {
                delay(1000)
                println("Job 1 Running on: ${Thread.currentThread().name}")
            }

            val job2 = scope.launch {
                delay(1000)
                println("Job 2 Running on: ${Thread.currentThread().name}")
            }

            println("Job 1 Status Coroutine Before Cancel ${job1.isActive}")
            println("Job 2 Status Coroutine Before ${job2.isActive}")
            job1.cancel()
            println("Job 1 Status Coroutine After Cancel ${job1.isActive}")
            println("Job 2 Status Coroutine After ${job2.isActive}")
            joinAll(job1, job2)
        }
    }

    @Test
    fun testCoroutineScopeAllScopeCancellable() {
        runBlocking {
            val scope = CoroutineScope(Dispatchers.IO).launch {
                val job1 = launch {
                    delay(1000)
                    println("Job 1 Running on: ${Thread.currentThread().name}")
                }

                val job2 = launch {
                    delay(1000)
                    println("Job 2 Running on: ${Thread.currentThread().name}")
                }

                println("Job 1 Status Coroutine After Cancel ${job1.isActive}")
                println("Job 2 Status Coroutine After Cancel ${job2.isActive}")
                joinAll(job1, job2)
            }
            scope.cancel()
        }
    }

    @Test
    fun testCoroutineScopeMultipleScopeCancellable() {
        runBlocking {
            val scope1 = CoroutineScope(Dispatchers.IO).launch {
                val job1 = launch {
                    delay(1000)
                    println("Job 1 - Scope 1 Running on: ${Thread.currentThread().name}")
                }

                val job2 = launch {
                    delay(1000)
                    println("Job 2 - Scope 1 Running on: ${Thread.currentThread().name}")
                }

                println("Job 1 - Scope 1 Status Coroutine After Cancel ${job1.isActive}")
                println("Job 2 - Scope 1 Status Coroutine After Cancel ${job2.isActive}")
                joinAll(job1, job2)
            }
            scope1.cancel()

            val scope2 = CoroutineScope(Dispatchers.IO).launch {
                val job1 = launch {
                    delay(1000)
                    println("Job 1 - Scope 2 Running on: ${Thread.currentThread().name}")
                }

                val job2 = launch {
                    delay(1000)
                    println("Job 2 - Scope 2 Running on: ${Thread.currentThread().name}")
                }

                println("Job 1 - Scope 2 Status Coroutine After Cancel ${job1.isActive}")
                println("Job 2 - Scope 2 Status Coroutine After Cancel ${job2.isActive}")
                joinAll(job1, job2)
            }
            scope2.join()
        }
    }
}