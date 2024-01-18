package mapping

fun main() {
    val names = listOf("Alice", "Bob", "Charlie")
    val indexedName = names.mapIndexed { index, value ->
        "$index $value"
    }
    println(indexedName)
}