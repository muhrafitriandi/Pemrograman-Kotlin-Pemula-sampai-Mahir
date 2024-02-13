package coroutine.kotlin.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.junit.jupiter.api.Test

class ChannelTest {
    @Test
    fun testChannel() {
        val channel = Channel<Int>()
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            println("Send data 1")
            channel.send(1)

            delay(1000)

            println("Send data 2")
            channel.send(2)
        }

        val jobReceive = scope.launch {
            println("Receive data ${channel.receive()}")
            println("Receive data ${channel.receive()}")
        }

        runBlocking {
            joinAll(jobSend, jobReceive)
            channel.close()
        }
    }
}