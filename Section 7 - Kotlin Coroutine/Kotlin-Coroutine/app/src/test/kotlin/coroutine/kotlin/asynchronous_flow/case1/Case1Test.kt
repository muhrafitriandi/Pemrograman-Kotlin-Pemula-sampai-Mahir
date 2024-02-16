package coroutine.kotlin.asynchronous_flow.case1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

data class User(val id: Int, val name: String)

class Case1Test {
    suspend fun fetchUsersFromAPI(): List<User> {
        delay(1000)
        return listOf(
            User(1, "Alice"),
            User(2, "Bob"),
            User(3, "Charlie"),
            User(4, "David"),
            User(5, "Eve")
        )
    }

    fun processUsers(users: List<User>): Flow<User> = flow {
        println("Start Flow")
        users.forEach { user ->
            delay(1000)
            println("Send: $user")
            emit(user)
        }
    }

    @Test
    fun testFetchUsers() {
        runBlocking {
            val users = fetchUsersFromAPI()

            processUsers(users).collect { user ->
                println("Receive: $user")
                println("----------")
            }
        }
    }
}