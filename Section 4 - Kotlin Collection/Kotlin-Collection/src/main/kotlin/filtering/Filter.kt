package filtering

import filtering.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 22)
    )

    val youngPeople = people.filter { it.age < 30 }
    println(youngPeople)
}