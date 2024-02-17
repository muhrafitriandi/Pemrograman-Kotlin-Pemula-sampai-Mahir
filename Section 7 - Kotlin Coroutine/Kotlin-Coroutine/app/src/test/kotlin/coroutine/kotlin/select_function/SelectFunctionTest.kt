package coroutine.kotlin.select_function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

class SelectFunctionTest {

    @Test
    fun testSelectFunctionDeferred() {
        val scope = CoroutineScope(Dispatchers.IO)
        val deferred1 = scope.async { delay(1000); 1000 }
        val deferred2 = scope.async { delay(2000); 2000 }
        val deferred3 = scope.async { delay(3000); 3000 }

        runBlocking {
            val win = select {
                deferred1.onAwait { it }
                deferred2.onAwait { it }
                deferred3.onAwait { it }
            }
            println("Win: $win")
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSelectFunctionChannel() {
        val scope = CoroutineScope(Dispatchers.IO)
        val receiveChannel1 = scope.produce { delay(1000); send(1000) }
        val receiveChannel2 = scope.produce { delay(2000); send(2000) }
        val receiveChannel3 = scope.produce { delay(3000); send(3000) }

        runBlocking {
            val win = select {
                receiveChannel1.onReceive { it }
                receiveChannel2.onReceive { it }
                receiveChannel3.onReceive { it }
            }
            println("Win: $win")
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testSelectFunctionDeferredChannel() {
        val scope = CoroutineScope(Dispatchers.IO)
        val deferred1 = scope.async { delay(1000); 1000 }
        val receiveChannel1 = scope.produce { delay(2000); send(2000) }
        val receiveChannel2 = scope.produce { delay(3000); send(3000) }

        runBlocking {
            val win = select {
                deferred1.onAwait { it }
                receiveChannel1.onReceive { it }
                receiveChannel2.onReceive { it }
            }
            println("Win: $win")
        }
    }
}