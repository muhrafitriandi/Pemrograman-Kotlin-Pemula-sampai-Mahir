package coroutine.kotlin.channel_buffer_overflow

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import org.junit.jupiter.api.Test

class ChannelBufferOverflowTest {
    @Test
    fun testBufferDropOldest() {
        val channel = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.DROP_OLDEST) // Kapasitas buffer: 10, dan elemen terlama akan dihapus
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(100) {
                channel.send(it + 1)
                println("Send data ${it + 1}")
            }
        }

        runBlocking {
            jobSend.join()

            val jobReceive = scope.launch {
                repeat(3) {
                    println("Receive data ${channel.receive()}") // will take the first 3 data in the channel, ie: 91-93.
                    println("----------")
                }
            }

            jobReceive.join()
            channel.close()
        }
    }

    @Test
    fun testBufferDropLatest() {
        val channel = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.DROP_LATEST) // Kapasitas buffer: 10, dan elemen terbaru akan dihapus
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(100) {
                channel.send(it + 1)
                println("Send data ${it + 1}")
            }
        }

        runBlocking {
            jobSend.join()

            val jobReceive = scope.launch {
                repeat(3) {
                    println("Receive data ${channel.receive()}") // will take the first 3 data in the channel, ie: 1-3.
                    println("----------")
                }
            }

            jobReceive.join()
            channel.close()
        }
    }

    @Test
    fun testBufferSuspend() {
        val channel = Channel<Int>(capacity = 10) // Kapasitas buffer: 10, by default, onBufferOverflow is SUSPEND
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSend = scope.launch {
            repeat(100) {
                channel.send(it + 1) // The next 10 data (ie 4-13) will be entered into the channel. And data 14-100 will be blocked until the channel buffer capacity is available again.
                println("Send data ${it + 1}")
            }
        }

        runBlocking {
            val jobReceive = scope.launch {
                repeat(3) {
                    println("Receive data ${channel.receive()}") // will receive 3 data, ie: 1-3.
                    println("----------")
                }
            }

            joinAll(jobSend, jobReceive)
            channel.close()
        }
    }
}