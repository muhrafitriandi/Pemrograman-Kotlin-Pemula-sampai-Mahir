package coroutine.kotlin.coroutine_scope_parent_child

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors

class CoroutineScopeParentChildTest {

    @Test
    fun testChildDispatcher() {
        val parentDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val parentScope = CoroutineScope(parentDispatcher)

        val job = parentScope.launch {
            println("Parent thread is: ${Thread.currentThread().name}")

            coroutineScope {
                launch {
                    println("Child thread is: ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.join()
        }
    }

    @Test
    fun testChildCancellable() {
        val parentDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val parentScope = CoroutineScope(parentDispatcher)

        val job = parentScope.launch {
            println("Parent thread is: ${Thread.currentThread().name}")

            coroutineScope {
                launch {
                    delay(2000)
                    println("Child thread is: ${Thread.currentThread().name}")
                }
            }
        }
        runBlocking {
            job.cancelAndJoin()
        }
    }
}