package coroutine.kotlin.coroutine_dispatcher

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class CoroutineDispatcher {
    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherDefault() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(15) {
                GlobalScope.launch(Dispatchers.Default) {
                    delay(1000)
                    println("Iteration $it running on: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherIO() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(15) {
                GlobalScope.launch(Dispatchers.IO) {
                    delay(1000)
                    println("Iteration $it running on: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherDefaultIO() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(15) {
                GlobalScope.launch(Dispatchers.Default) {
                    delay(1000)
                    println("Iteration $it running on Default: ${Thread.currentThread().name}")
                }
                GlobalScope.launch(Dispatchers.IO) {
                    delay(1000)
                    println("Iteration $it running on IO: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherUnconfined() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(15) {
                GlobalScope.launch(Dispatchers.Unconfined) {
                    println("Iteration $it running on: ${Thread.currentThread().name}")
                    delay(1000)
                    println("Iteration $it running on after: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherConfined() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(15) {
                GlobalScope.launch {
                    println("Iteration $it running on: ${Thread.currentThread().name}")
                    delay(1000)
                    println("Iteration $it running on after: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testDispatcherConfinedUnconfined() {
        runBlocking {
            println("runBlocking running on: ${Thread.currentThread().name}")
            repeat(3) {
                GlobalScope.launch(Dispatchers.Unconfined) {
                    println("Unconfined $it running on: ${Thread.currentThread().name}")
                    delay(1000)
                    println("Unconfined $it running on after: ${Thread.currentThread().name}")
                }
                GlobalScope.launch {
                    println("Confined $it running on: ${Thread.currentThread().name}")
                    delay(1000)
                    println("Confined $it running on after: ${Thread.currentThread().name}")
                }
            }
            delay(2000)
        }
    }
}