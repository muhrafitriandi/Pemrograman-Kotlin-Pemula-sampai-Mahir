package coroutine.kotlin.channel_undelivered_element

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ChannelUndeliveredElementTest {
    @Test
    fun testUndeliveredElement() {
        val channel = Channel<Int>(capacity = 10) {
            println("Undelivered Element: $it")
        }
        val scope = CoroutineScope(Dispatchers.IO)

        channel.close()
        val job = scope.launch {
            runCatching {
                channel.send(10)
                channel.send(9)
            }.onFailure { e ->
                println("Error: ${e.message}")
            }
        }

        runBlocking {
            job.join()
        }
    }
}