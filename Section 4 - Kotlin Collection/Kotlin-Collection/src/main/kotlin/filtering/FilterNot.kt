package filtering

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val oddNumbers = numbers.filterNot { it % 2 == 0 }
    println(oddNumbers)
}