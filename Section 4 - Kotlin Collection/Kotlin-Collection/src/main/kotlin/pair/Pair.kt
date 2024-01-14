package pair

fun main() {
    val coordinates1 = Pair(-6.193125, 106.821810)
    println("Latitude: ${coordinates1.first}, Longitude: ${coordinates1.second}")

    val coordinates2 = -6.193125 to 106.821810
    println("Latitude: ${coordinates2.first}, Longitude: ${coordinates2.second}")
}