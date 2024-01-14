package collection

fun <T> displayMutableCollection(collection: MutableCollection<T>) {
    for (item in collection) println(item)
}

fun main() {
    // displayMutableCollection(listOf("mangga", "apel", "jeruk")) // error, List bukan turunan dari MutableCollection melainkan Collection
    // displayMutableCollection(setOf("mangga", "apel", "jeruk")) // error, Set bukan turunan dari MutableCollection melainkan Collection
    // displayMutableCollection(mapOf("mangga" to "manggo").entries) // error, Set bukan turunan dari MutableCollection melainkan Collection
    // displayCollection(mapOf("mangga" to "manggo")) // error, Map bukan turunan dari MutableCollection

    displayMutableCollection(mutableListOf("mangga", "apel", "jeruk"))
    displayMutableCollection(mutableSetOf("mangga", "apel", "jeruk"))
    displayMutableCollection(mutableMapOf("mangga" to "mango").entries)
    // displayCollection(mutableMapOf("mangga" to "manggo")) // error, Map bukan turunan dari MutableCollection
}