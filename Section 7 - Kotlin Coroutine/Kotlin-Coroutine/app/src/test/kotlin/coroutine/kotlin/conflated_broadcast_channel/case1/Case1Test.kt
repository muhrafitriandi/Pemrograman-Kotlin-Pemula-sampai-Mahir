package coroutine.kotlin.conflated_broadcast_channel.case1

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.ReceiveChannel
import org.junit.jupiter.api.Test

data class Temperature(val value: Double)

@OptIn(ObsoleteCoroutinesApi::class)
fun CoroutineScope.sensorDataProducer(channel: ConflatedBroadcastChannel<Temperature>) = launch {
    repeat(10) {
        delay(1000)
        val temperature = Temperature(20 + it * 0.5) // Simulate temperature data
        channel.send(temperature)
        println("Send: $temperature")
    }
}

fun CoroutineScope.temperatureMonitor(channel: ReceiveChannel<Temperature>) = launch {
    repeat(10) {
        delay(2000)
        println("Current temperature: ${channel.receive()}")
    }
}

class Case1Test {
    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun testTemperatureMonitor() {
        val channel = ConflatedBroadcastChannel<Temperature>()
        val scope = CoroutineScope(Dispatchers.IO)

        val job = scope.launch {
            sensorDataProducer(channel)
            temperatureMonitor(channel.openSubscription())
        }

        runBlocking {
            delay(13_000)
            job.cancel()
        }
    }
}