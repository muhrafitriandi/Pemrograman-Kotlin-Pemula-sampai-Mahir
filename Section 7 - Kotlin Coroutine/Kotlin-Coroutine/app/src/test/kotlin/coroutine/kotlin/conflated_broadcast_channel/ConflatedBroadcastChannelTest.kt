package coroutine.kotlin.conflated_broadcast_channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import org.junit.jupiter.api.Test

class ConflatedBroadcastChannelTest {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testConflatedBroadcastChannel() {
        val channel = ConflatedBroadcastChannel<Int>()
        val scope = CoroutineScope(Dispatchers.IO)

        val jobSender = scope.launch {
            repeat(10) {
                delay(1000)
                println("Send: $it")
                channel.send(it)
            }
        }

        val jobReceiver = scope.launch {
            repeat(10) {
                delay(2000)
                println("Receive: ${channel.openSubscription().receive()}")
            }
        }

        runBlocking {
            joinAll(jobSender, jobReceiver)
            channel.close()
        }
    }
}