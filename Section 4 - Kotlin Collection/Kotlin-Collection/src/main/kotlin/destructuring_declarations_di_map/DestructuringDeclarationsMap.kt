package destructuring_declarations_di_map

fun main() {
    val personMap = mapOf(
        "name" to "Alice",
        "age" to 30,
        "city" to "Wonderland"
    )

    // Manual
//    personMap.forEach {
//        println("${it.component1()} : ${it.component2()}")
//    }
//    for ((key, value) in personMap) {
//        println("$key : $value")
//    }

    // Melakukan Destructuring Declarations pada Map
    personMap.forEach { (key, value) ->
        println("$key : $value")
    }
}