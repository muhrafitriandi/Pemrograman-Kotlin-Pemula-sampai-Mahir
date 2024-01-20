package retrieve_by_condition

import retrieve_by_condition.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 22),
        Person("Bob", 30),
        Person("Charlie", 25),
        Person("David", 35)
    )

    // Mendapatkan elemen pertama yang memenuhi kondisi
    val person1 = people.first { it.age > 30 }
    println("First person older than 30: $person1")

    // Mendapatkan elemen terakhir yang memenuhi kondisi
    val person2 = people.last { it.age < 30 }
    println("Last person younger than 30: $person2")

    // Mendapatkan elemen pertama yang memenuhi kondisi atau null jika tidak ada
    val person3 = people.firstOrNull { it.name.startsWith("B") }
    println("First person with name starting with 'B' or null: $person3")

    // Mendapatkan elemen terakhir yang memenuhi kondisi atau null jika tidak ada
    val person4 = people.lastOrNull { it.name.endsWith("e") }
    println("Last person with name ending with 'e' or null: $person4")

    // Mencari elemen pertama yang memenuhi kondisi
    val person5 = people.find { it.name.contains("li") }
    println("First person with 'li' in the name or null: $person5")

    // Mencari elemen terakhir yang memenuhi kondisi
    val person6 = people.findLast { it.age < 30 }
    println("Last person younger than 30 or null: $person6")
}