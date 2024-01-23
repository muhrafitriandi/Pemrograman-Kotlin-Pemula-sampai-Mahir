package destructuring_declarations_di_map.case1

import destructuring_declarations_di_map.data.Person

fun main() {
    val people = listOf(
        Person("Alice", 25, "Jakarta"),
        Person("Bob", 30, "Bekasi"),
        Person("Charlie", 22, "Depok")
    )

    // Mengubah List menjadi Map, Name sebagai key
    val peopleToMap = people.associateBy { it.name }

    // Melakukan Destructuring Declarations pada Map
    peopleToMap.forEach { (key, value) ->
        println("$key : $value")
    }
}