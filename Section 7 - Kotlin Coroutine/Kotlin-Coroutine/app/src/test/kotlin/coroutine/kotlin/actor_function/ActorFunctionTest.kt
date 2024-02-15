package coroutine.kotlin.actor_function

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import org.junit.jupiter.api.Test

class ActorFunctionTest {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testActorFunction() {
        val scope = CoroutineScope(Dispatchers.IO)
        val channel: SendChannel<Int> = scope.actor(capacity = 10) {
            repeat(10) {
                delay(2000)
                println("Data receive: ${receive()}")
            }
        }

        scope.launch {
            repeat(10) {
                delay(500)
                println("Send: $it")
                channel.send(it)
            }
        }

        runBlocking {
            delay(21_000)
            channel.close()
        }
    }
}