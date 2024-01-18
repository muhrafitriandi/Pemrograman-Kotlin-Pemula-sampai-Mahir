package flattening

import flattening.data.Person

fun main() {
    val people = listOf(
        Person("Alice", listOf("Reading", "Photography")),
        Person("Bob", listOf("Cooking", "Gardening")),
        Person("Charlie", listOf("Traveling", "Photography"))
    )

    val mapHobbies: List<List<String>> = people.map { it.hobbies }
    val mapFlatten: List<String> = people.map { it.hobbies }.flatten().distinct()

    val allHobbies: List<String> = people.flatMap { it.hobbies }.distinct()
    val countHobbies: Map<String, Int> = people.flatMap { it.hobbies }.groupingBy { it }.eachCount()
    println(allHobbies)
    println(countHobbies)
}