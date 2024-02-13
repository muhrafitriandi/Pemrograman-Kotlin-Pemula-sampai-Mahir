package coroutine.kotlin.channel_backpressure.case1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

data class Message(val sender: String, val content: String)

data class User(val id: String, val name: String)


class Case1Test {

    suspend fun sendMessage(channel: SendChannel<Pair<User, Message>>, to: User, message: Message) {
        channel.send(to to message)
        println("${message.sender} send message: ${message.content} to ${to.name}")
    }

    suspend fun receiveMessage(channel: ReceiveChannel<Pair<User, Message>>) {
        val (user, message) = channel.receive()

        if (message.sender != user.name) {
            println("${user.name} received message from ${message.sender}: ${message.content}")
            println("----------")
        }
    }

    @DisplayName("sender can only spam messages 3 times")
    @Test
    fun testOnly3SpamMessage() {
        val messageChannel = Channel<Pair<User, Message>>(capacity = 3)
        val user1 = User("1", "Rafi")
        val user2 = User("2", "Hilman")

        runBlocking {
            val jobSender = launch {
                repeat(10) { // Data 4-6 will be entered into the channel, while data 7-10 will be blocked. Because the capacity has run out.
                    delay(500)
                    sendMessage(messageChannel, user2, Message(user1.name, "Hello Hilman ${it + 1}"))
                }
            }

            val jobReceiver = launch {
                repeat(3) {
                    delay(2000)
                    receiveMessage(messageChannel)
                }
            }

            joinAll(jobSender, jobReceiver)
            messageChannel.close()
        }
    }
}