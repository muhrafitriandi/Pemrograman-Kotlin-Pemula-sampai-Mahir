package coroutine.kotlin.shared_flow.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.buffer
import org.junit.jupiter.api.Test
import java.util.*

data class Message(val sender: String, val content: String)

class ConversationManager {
    private val _messages = MutableSharedFlow<Message>()
    val messages = _messages.asSharedFlow().buffer(10)

    suspend fun sendMessage(message: Message) {
        _messages.emit(message)
        println("${Date()}")
        delay(500)
    }
}

class Case1Test {

    @Test
    fun testMessage() {
        val scope = CoroutineScope(Dispatchers.IO)
        val conversationManager = ConversationManager()

        val jobSender = scope.launch {
            repeat(10) {
                conversationManager.sendMessage(Message("Pengguna A", "Halo semua!"))
            }
        }

        val jobReceiver1 = scope.launch {
            repeat(10) {
                conversationManager.messages.collect { (sender, content) ->
                    delay(2000)
                    println("Pengguna 1 menerima pesan dari $sender: $content -- ${Date()}")
                }
            }
        }

        val jobReceiver2 = scope.launch {
            repeat(10) {
                conversationManager.messages.collect { (sender, content) ->
                    delay(4000)
                    println("Pengguna 2 menerima pesan dari $sender: $content -- ${Date()}")
                }
            }
        }

        runBlocking {
            joinAll(jobSender, jobReceiver1, jobReceiver2)
        }
    }
}