package filtering

fun main() {
    val numbers = listOf(10, 20, 30, 40, 50)

    val filteredNumbers = numbers.filterIndexed { index, _ -> index % 2 == 0}
    println(filteredNumbers)
}