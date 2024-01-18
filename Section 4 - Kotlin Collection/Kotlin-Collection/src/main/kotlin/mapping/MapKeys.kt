package mapping

fun main() {
    val people = mapOf(
        1 to "Muhammad",
        2 to "Rafi",
        3 to "Triandi"
    )

    val printPeople = people.mapKeys { it.key * 10 }
    println(printPeople)
}