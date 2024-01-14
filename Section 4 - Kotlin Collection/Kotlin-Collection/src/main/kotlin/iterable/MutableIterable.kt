package iterable

fun <T> displayMutableIterable(iterable: MutableIterable<T>, action: (MutableIterator<T>) -> Unit) {
//    for (item in iterable) println(item)

    val iterator = iterable.iterator()
    action(iterator)
}

fun printOddNumber(iterator: MutableIterator<Int>) {
    while (iterator.hasNext()) {
        val item = iterator.next()
        if (item % 2 == 0) iterator.remove()
        else print(item)
    }
}

fun main() {
//    displayMutableIterable(listOf("mangga", "apel", "jeruk")) // error, List bukan turunan dari MutableIterable melainkan Iterable/Collection
//    displayMutableIterable(setOf("mangga", "apel", "jeruk")) // error, Set bukan turunan dari MutableIterable melainkan Iterable/Collection
//    displayMutableIterable(mapOf("mangga" to "mango").entries) // error, Set bukan turunan dari MutableIterable melainkan Iterable/Collection

    displayMutableIterable(mutableListOf(1, 2, 3, 4, 5)) { printOddNumber(it) }
    displayMutableIterable(mutableSetOf(1, 2, 3, 4, 5)) { printOddNumber(it) }
    displayMutableIterable(mutableMapOf("satu" to 1, "dua" to 2, "tiga" to 3, "empat" to 4, "lima" to 5).values) { printOddNumber(it) }
}