package flattening

fun main() {
    val nestedList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5),
        listOf(6, 7, 8)
    )

    val flattenedList = nestedList.flatten()
    println(flattenedList)
}