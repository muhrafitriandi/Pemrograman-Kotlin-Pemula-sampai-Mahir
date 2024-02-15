package coroutine.kotlin.broadcast_channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.broadcast
import org.junit.jupiter.api.Test

class BroadcastChannelTest {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testBroadcastChannel() {
        val channel = BroadcastChannel<Int>(capacity = 10)
        val scope = CoroutineScope(Dispatchers.IO)

        val receiver1: ReceiveChannel<Int> = channel.openSubscription()
        val receiver2: ReceiveChannel<Int> = channel.openSubscription()

        val jobSender = scope.launch {
            repeat(10) {
                delay(500)
                println("Send data $it")
                channel.send(it)
            }
        }

        val jobReceiver1 = scope.launch {
            repeat(10) {
                println("Receive 1 data ${receiver1.receive()}")
            }
        }

        val jobReceiver2 = scope.launch {
            repeat(10) {
                println("Receive 2 data ${receiver2.receive()}")
            }
        }

        runBlocking {
            joinAll(jobSender, jobReceiver1, jobReceiver2)
        }
    }

    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testBroadcastFunction() {
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSender: BroadcastChannel<Int> = scope.broadcast(capacity = 10) {
            repeat(10) {
                delay(500)
                println("Send data $it")
                send(it)
            }
        }

        val jobReceiver1 = scope.launch {
            repeat(10) {
                println("Receive 1 data ${jobSender.openSubscription().receive()}")
            }
        }

        val jobReceiver2 = scope.launch {
            repeat(10) {
                println("Receive 2 data ${jobSender.openSubscription().receive()}")
            }
        }

        runBlocking {
            joinAll(jobReceiver1, jobReceiver2)
        }
    }
}