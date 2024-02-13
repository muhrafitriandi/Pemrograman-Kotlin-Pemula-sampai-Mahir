package coroutine.kotlin.channel.case1

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

data class Message(val sender: String, val content: String)

data class User(val id: String, val name: String)

class Case1Test {

    suspend fun sendMessage(channel: SendChannel<Pair<User, Message>>, to: User, message: Message) {
        println("${message.sender} send message: ${message.content} to ${to.name}")
        channel.send(to to message)
    }

    suspend fun receiveMessage(channel: ReceiveChannel<Pair<User, Message>>) {
        val (user, message) = channel.receive()

        if (message.sender != user.name) {
            println("${user.name} received message from ${message.sender}: ${message.content}")
            println("----------")
        }
    }

    @Test
    fun testMessage() {
        val messageChannel = Channel<Pair<User, Message>>()
        val user1 = User("1", "Rafi")
        val user2 = User("2", "Hilman")

        runBlocking {
            val jobSender = launch {
                repeat(5) {
                    sendMessage(messageChannel, user2, Message(user1.name, "Hello Hilman"))
                    delay(1000)
                }
            }

            val jobReceiver = launch {
                repeat(3) {
                    receiveMessage(messageChannel)
                }
            }

            joinAll(jobSender, jobReceiver)
            messageChannel.close()
        }
    }
}