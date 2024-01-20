package custom_order

import custom_order.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 30, 50000.0, false),
        Person("Bob", 35, 60000.0, false),
        Person("Thomas", 40, 85000.0, false),
        Person("Wilson", 45, 30000.0, false),
        Person("Charlie", 50, 45000.0, false),
        Person("David", 55, 55000.0, false)
    )

    // Mengurutkan berdasarkan umur
    val sortedByAge = people.sortedBy { it.age }
    println("Sorted by age: $sortedByAge")

    // Mengurutkan berdasarkan nama secara descending
    val sortedByDescendingName = people.sortedByDescending { it.name }
    println("Sorted by name descending: $sortedByDescendingName")

    // Mengurutkan berdasarkan kriteria kustom (misalnya, berdasarkan umur)
    val custom1SortedByCustomCriteria = people.sortedWith { people1, people2 ->
        people1.age.compareTo(people2.age)
    }
    val custom2SortedByCustomCriteria = people.sortedWith(compareBy { it.age })
    val sortedByCustomCriteria = people.sortedBy { it.age }
    println("Sorted by custom criteria (name length): $sortedByCustomCriteria")

    // Mengurutkan berdasarkan beberapa kriteria (umur, gaji)
    val sortedByMultipleCriteria1 = people.sortedWith(compareBy<Person> { it.age }.thenBy { it.salary })
    val sortedByMultipleCriteria2 = people.sortedWith(compareBy(Person::age, Person::salary))
    println("Sorted by age then by salary: $sortedByMultipleCriteria2")
}
