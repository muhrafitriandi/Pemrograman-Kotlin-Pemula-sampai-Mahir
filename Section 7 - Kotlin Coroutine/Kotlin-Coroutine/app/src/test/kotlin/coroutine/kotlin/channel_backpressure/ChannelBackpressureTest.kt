package coroutine.kotlin.channel_backpressure

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.junit.jupiter.api.Test

class ChannelBackpressureTest {
    @Test
    fun testChannelCustomCapacity() {
        val channel = Channel<Int>(capacity = 5)
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(10) {
                delay(500)
                channel.send(it + 1)
                println("Send data ${it + 1}")
            }
        }

        val jobReceive = scope.launch {
            repeat(5) {
                delay(2000)
                println("Receive data ${channel.receive()}")
                println("----------")
            }
        }

        runBlocking {
            joinAll(jobSend, jobReceive)
            channel.close()
        }
    }

    @Test
    fun testChannelUnlimitedCapacity() {
        val channel = Channel<Int>(capacity = Channel.UNLIMITED)
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(50) {
                delay(500)
                channel.send(it + 1)
                println("Send data ${it + 1}")
            }
        }

        val jobReceive = scope.launch {
            repeat(5) {
                delay(2000)
                println("Receive data ${channel.receive()}")
                println("----------")
            }
        }

        runBlocking {
            joinAll(jobSend, jobReceive)
            channel.close()
        }
    }

    @Test
    fun testChannelConflatedCapacity() {
        val channel = Channel<Int>(capacity = Channel.CONFLATED)
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(10) {
                delay(500)
                channel.send(it + 1)
                println("Send data ${it + 1}")
            }
        }

        runBlocking {
            jobSend.join()

            val jobReceive = scope.launch {
                repeat(5) { // will be blocked, because we want to receive 5 data while data 1-9 in the channel has been deleted
                    println("Receive data ${channel.receive()}") // with this, it will always be the last data retrieved
                    println("----------")
                }
            }

            jobReceive.join()
            channel.close()
        }
    }
}