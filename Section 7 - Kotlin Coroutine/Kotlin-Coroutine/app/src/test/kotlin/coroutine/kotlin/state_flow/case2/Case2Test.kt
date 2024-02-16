package coroutine.kotlin.state_flow.case2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test


enum class PlayerState {
    Playing,
    Paused,
    Stopped
}

class Case2Test {
    @Test
    fun testPlayerState() {
        runBlocking {
            // StateFlow to hold the current player state
            val playerState = MutableStateFlow(PlayerState.Stopped)

            // Launch a coroutine to print state based on StateFlow
            launch {
                playerState.collect { state ->
                    println("Player State: $state")
                }
            }
            // Launch a coroutine to simulate user actions
            launch {
                // Play/pause/stop actions update the state
                playerState.emit(PlayerState.Playing)
                delay(2000)
                playerState.emit(PlayerState.Paused)
                delay(1000)
                playerState.emit(PlayerState.Stopped)
            }
            delay(Long.MAX_VALUE)
        }
    }
}