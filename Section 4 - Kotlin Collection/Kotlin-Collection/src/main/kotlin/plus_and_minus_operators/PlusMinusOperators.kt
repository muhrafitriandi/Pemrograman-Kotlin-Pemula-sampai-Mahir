package plus_and_minus_operators

fun main() {
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(3, 4, 5)

    val map1 = mapOf(
        "m" to "muhammad",
        "r" to "rafi",
        "t" to "triandi"
    )

    val newListPlusElement = list1 + 4
    println("list1 + 4: $newListPlusElement")

    val newListPlusCollection = list1 + list2
    println("list1 + list2: $newListPlusCollection")

    val newListMinusElement = list1 - 2
    println("list1 - 2: $newListMinusElement")

    val newListMinusCollection = list1 - list2
    println("list1 - list2: $newListMinusCollection")

    val newMapPlus = map1 + mapOf("i" to "iron")
    println("map1 + iron: $newMapPlus")

    val newMapMinus = map1 - "r"
    println("map1 - r: $newMapMinus")
}