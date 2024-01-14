package iterable

fun <T> displayIterable(iterable: Iterable<T>) {
//    for (item in iterable) println(item)

    val iterator = iterable.iterator()
    while (iterator.hasNext()) println(iterator.next())
}

fun main() {
    displayIterable(listOf("mangga", "apel", "jeruk"))
    displayIterable(setOf("mangga", "apel", "jeruk"))
    displayIterable(mapOf("mangga" to "mango").entries)
}