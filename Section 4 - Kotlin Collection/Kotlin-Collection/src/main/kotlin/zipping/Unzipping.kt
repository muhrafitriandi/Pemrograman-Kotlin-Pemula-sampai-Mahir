package zipping

fun main() {
    val student: List<Pair<Int, String>> = listOf(
        1402019001 to "Rafi",
        1402019002 to "Agung",
        1402019003 to "Aldi"
    )

    val (npm, name) = student.unzip()
    println("NPM: $npm")
    println("Name: $name")
}