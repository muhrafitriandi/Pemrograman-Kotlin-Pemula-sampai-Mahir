package mapping

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val oddNumbers = numbers.mapNotNull { if (it % 2 == 0) null else it }
    println(oddNumbers)
}