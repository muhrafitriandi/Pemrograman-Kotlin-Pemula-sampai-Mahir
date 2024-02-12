package coroutine.kotlin.mutex.case2

import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

data class Person(val name: String, var saldo: Int)
data class Item(val name: String, val price: Int)

val mutex = Mutex()

class Case2Test {
    @Test
    fun testProblemMutex() { // case for one (person) to many (items)
        val person = Person("Rafi", 1000)
        val items = listOf(
            Item("Laptop", 1500),
            Item("MousePad", 200),
            Item("Headphone", 1000),
            Item("Mouse", 700),
            Item("Keyboard", 800),
            Item("iPhone", 1100)
        )

        runBlocking {
            val time = measureTimeMillis {
                val jobs = List(items.size) { index ->
                    launch {
                        transactionProcessWithMutex(person, items[index])
//                        transactionProcessWithoutMutex(person, items[index])
                    }
                }
                jobs.joinAll()
            }
            println("----------")
            println("Total time: $time")
            println("----------")
        }

        println("${person.name}'s final saldo: ${person.saldo}")
    }

    suspend fun transactionProcessWithoutMutex(person: Person, item: Item) {
        if (person.saldo >= item.price) {
            delay(1000) // Simulasi waktu proses transaksi
            person.saldo -= item.price
            println("${person.name} membeli ${item.name}")
        } else {
            println("${person.name} tidak memiliki cukup saldo untuk membeli ${item.name}")
        }
    }

    suspend fun transactionProcessWithMutex(person: Person, item: Item) {
        mutex.withLock {
            if (person.saldo >= item.price) {
                delay(1000) // Simulasi waktu proses transaksi
                person.saldo -= item.price
                println("${person.name} membeli ${item.name}")
            } else {
                println("${person.name} tidak memiliki cukup saldo untuk membeli ${item.name}")
            }
        }
    }
}