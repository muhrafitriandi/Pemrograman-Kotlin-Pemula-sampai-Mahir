package testing

import testing.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 22),
        Person("David", 35),
        Person("Eva", 28)
    )

    val isThereAnyoneUnder20 = people.any { it.age < 20 }
    println("Is there anyone under 20? $isThereAnyoneUnder20")

    val isNoOneOver40 = people.none { it.age > 40 }
    println("Is no one over 40? $isNoOneOver40")

    val areAllPeopleOver18 = people.all { it.age > 18 }
    println("Are all people over 18? $areAllPeopleOver18")

    val isAnyonePresent = people.any()
    println("Is anyone present? $isAnyonePresent")

    val isNoOnePresent = people.none()
    println("Is no one present? $isNoOnePresent")
}