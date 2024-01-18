package partitioning

import partitioning.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 22),
        Person("David", 35),
        Person("Eva", 28)
    )

    // val partition: Pair<List<Person>, List<Person>> = people.partition { it.age < 30 }
    val (youngPeople, oldPeople) = people.partition { it.age < 30 }

    println("Young People: $youngPeople")
    println("Old People: $oldPeople")
}