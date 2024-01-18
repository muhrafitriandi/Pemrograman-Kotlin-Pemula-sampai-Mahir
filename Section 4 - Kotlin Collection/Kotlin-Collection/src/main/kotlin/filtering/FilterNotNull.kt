package filtering

fun main() {
    val data: List<Any?> = listOf(1, null, "Udin", null, 3.0, true)

    val dataNotNull = data.filterNotNull()
    println(dataNotNull)
}