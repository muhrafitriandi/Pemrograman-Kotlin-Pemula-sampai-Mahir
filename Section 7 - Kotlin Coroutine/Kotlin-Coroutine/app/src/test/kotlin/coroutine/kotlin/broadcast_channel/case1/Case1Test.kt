package coroutine.kotlin.broadcast_channel.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import org.junit.jupiter.api.Test

// Class to represent a chat message
data class ChatMessage(val sender: String, val message: String)

// Function to send chat messages to the broadcast channel
@OptIn(ObsoleteCoroutinesApi::class)
fun CoroutineScope.chatMessageProducer(channel: BroadcastChannel<ChatMessage>) = launch {
    repeat(5) {
        val message = ChatMessage("Rafi", "Hello $it!")
        channel.send(message)
        delay(1000) // Simulate sending message every second
    }
}

// Function to consume chat messages from the broadcast channel
fun CoroutineScope.chatMessageConsumer(channel: ReceiveChannel<ChatMessage>) = launch {
    repeat(5) {
        val message = channel.receive()
        println("${message.sender}: ${message.message}")
    }
}

class Case1Test {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testChatMessage() {
        runBlocking {
            val chatChannel = BroadcastChannel<ChatMessage>(capacity = 1) // Create a BroadcastChannel with conflated behavior

            // Create a producer coroutine to send chat messages
            chatMessageProducer(chatChannel)

            // Create multiple consumer coroutines to consume chat messages
            repeat(2) {
                chatMessageConsumer(chatChannel.openSubscription())
            }

            delay(5000)
            chatChannel.close() // Close the channel when finished
        }
    }
}