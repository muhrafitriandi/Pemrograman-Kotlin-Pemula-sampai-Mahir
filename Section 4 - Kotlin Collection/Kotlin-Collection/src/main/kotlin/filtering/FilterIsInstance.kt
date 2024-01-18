package filtering

fun main() {
    val mixedList = listOf(1, "two", 3.0, "four", 5)

    val numbersInt = mixedList.filterIsInstance<Int>()
    val numbersString = mixedList.filterIsInstance<String>()
    println(numbersInt)
    println(numbersString)
}