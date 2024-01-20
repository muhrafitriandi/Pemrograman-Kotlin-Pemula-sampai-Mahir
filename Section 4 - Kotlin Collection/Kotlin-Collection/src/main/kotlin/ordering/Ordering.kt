package ordering

fun main() {
    val numbers = listOf(4, 6, 7, 10, 2, 3, 5, 9, 1, 8)

    val sortedAsc = numbers.sorted()
    println(sortedAsc)

    val sortedDesc = numbers.sortedDescending()
    println(sortedDesc)
}