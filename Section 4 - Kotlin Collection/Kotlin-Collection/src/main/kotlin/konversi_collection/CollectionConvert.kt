package konversi_collection

fun main() {
    val array = arrayOf(2, 6, 3, 5, 1, 7, 8, 4, 6)
    val range = 1..5

    val arrayToList = array.toList()
    val arrayToMutableList = array.toMutableList()
    val arrayToSet = array.toSet()
    val arrayToMutableSet = array.toMutableSet()
    val arrayToCollection = array.toCollection(mutableListOf())
    val arrayToHashSet = array.toHashSet()
    val arrayToSortedSet = array.toSortedSet()
    val arrayToSortedComplexSet = array.toSortedSet(compareByDescending { it })

    val rangeToList = range.toList()
    val rangeToMutableList = range.toMutableList()
    val rangeToSet = range.toSet()
    val rangeToMutableSet = range.toMutableSet()
    val rangeToCollection = range.toCollection(mutableListOf())
    val rangeToHashSet = range.toHashSet()
    val rangeToSortedSet = range.toSortedSet()
    val rangeToSortedComplexSet = range.toSortedSet(compareByDescending { it })

    println(array.joinToString())
    println(arrayToList)
    println(arrayToMutableList)
    println(arrayToSet)
    println(arrayToMutableSet)
    println(arrayToCollection)
    println(arrayToHashSet)
    println(arrayToSortedSet)
    println(arrayToSortedComplexSet)
}