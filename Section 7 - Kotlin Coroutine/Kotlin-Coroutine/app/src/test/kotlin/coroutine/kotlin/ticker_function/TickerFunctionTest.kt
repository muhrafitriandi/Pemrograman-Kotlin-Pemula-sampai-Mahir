package coroutine.kotlin.ticker_function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.ticker
import org.junit.jupiter.api.Test
import java.util.*

class TickerFunctionTest {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testTickerFunction() {
        val scope = CoroutineScope(Dispatchers.IO)
        val job = scope.launch {
            val channel: ReceiveChannel<Unit> = ticker(1000)
            repeat(10) {
                channel.receive()
                println(Date())
            }
        }

        runBlocking {
            job.join()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testWithoutTickerFunction() {
        val scope = CoroutineScope(Dispatchers.IO)
        val jobSender: ReceiveChannel<Unit> = scope.produce {
            repeat(10) {
                send(Unit)
            }
        }

        val jobReceiver = scope.launch {
            repeat(10) {
                delay(1000)
                jobSender.receive()
                println(Date())
            }
        }

        runBlocking {
            jobReceiver.join()
        }
    }
}