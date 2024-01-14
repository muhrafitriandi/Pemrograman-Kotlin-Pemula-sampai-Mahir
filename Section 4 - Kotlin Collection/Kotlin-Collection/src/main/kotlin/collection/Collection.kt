package collection

fun <T> displayCollection(collection: Collection<T>) {
    for (item in collection) println(item)
}

fun main() {
    displayCollection(listOf("mangga", "apel", "jeruk"))
    displayCollection(setOf("mangga", "apel", "jeruk"))
    displayCollection(mapOf("mangga" to "mango").entries)
    // displayCollection(mapOf("mangga" to "manggo")) // error, Map bukan turunan dari Collection
}