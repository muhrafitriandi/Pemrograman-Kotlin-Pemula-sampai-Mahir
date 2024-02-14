package coroutine.kotlin.produce_function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import org.junit.jupiter.api.Test

class ProduceFunctionTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testProduceFunction() {
        val scope = CoroutineScope(Dispatchers.IO)

        val channel: ReceiveChannel<Int> = scope.produce { // will not block
            repeat(10) {
                println("Send data $it")
                send(it)
                delay(500)
            }
        }

        val jobReceiver = scope.launch {
            repeat(10) {
                println("Data receive: ${channel.receive()}")
            }
        }

        runBlocking {
            jobReceiver.join()
        }
    }

    @Test
    fun testWithoutProduceFunction() {
        val scope = CoroutineScope(Dispatchers.IO)
        val channel = Channel<Int>()

        val jobSender = scope.launch {
            repeat(2) {
                println("Send data $it")
                channel.send(it)
                delay(500)
            }
        }

        val jobReceiver = scope.launch {
            repeat(9) { // will block, because there is 1 piece of data that has not been retrieved
                println("Data receive: ${channel.receive()}")
            }
        }


        runBlocking {
            joinAll(jobSender, jobReceiver)
            channel.close()
        }
    }
}