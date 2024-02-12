package coroutine.kotlin.mutex.case1

import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

data class Person(val name: String, var saldo: Int)
data class Item(val name: String, val price: Int, var stock: Int)

val mutex = Mutex()

class Case1Test {

    @Test
    fun testProblemMutex() { // case for many (persons) to one (item)
        val persons = listOf(
            Person("Bob", 700),
            Person("Rafi", 800),
            Person("Yandi", 600),
            Person("John", 1000),
            Person("Alice", 1200),
            Person("Zidan", 1500)
        )
        val item = Item("Laptop", 800, 2)

        runBlocking {
            val time = measureTimeMillis {
                val jobs = List(persons.size) { index ->
                    launch {
                        buyItemWithMutex(persons[index], item)
                        // buyItemWithoutMutex(persons[index], item)
                    }
                }
                jobs.joinAll()
            }
            println("----------")
            println("Total time: $time")
            println("----------")
        }

        persons.forEach { println("${it.name}'s final saldo: ${it.saldo}") }
    }

    suspend fun buyItemWithoutMutex(person: Person, item: Item) {
        if (person.saldo >= item.price && item.stock > 0) {
            delay(1000) // Simulasi waktu pembelian
            person.saldo -= item.price
            item.stock--
            println("${person.name} membeli ${item.name}")
        } else {
            println("${person.name} tidak dapat membeli ${item.name}")
        }
    }

    suspend fun buyItemWithMutex(person: Person, item: Item) {
        mutex.withLock {
            if (person.saldo >= item.price && item.stock > 0) {
                delay(1000) // Simulasi waktu pembelian
                person.saldo -= item.price
                item.stock--
                println("${person.name} membeli ${item.name}")
            } else {
                println("${person.name} tidak dapat membeli ${item.name}")
            }
        }
    }
}