package association

import association.data.Person

fun main() {
    val people = listOf(
        Person(1, "Alice", 23),
        Person(2, "Bob", 25),
        Person(3, "Charlie", 30)
    )

    val idToNameMap = people.associate { person -> person.id to person.name }
    println(idToNameMap)
}