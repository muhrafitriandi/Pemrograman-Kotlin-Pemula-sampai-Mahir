package generic_extension_function.case

fun <T> List<T>.printElements() {
    for (element in this) {
        println(element)
    }
}

fun main() {
    val arrayInt = listOf(1, 2, 3, 4, 5)
    arrayInt.printElements()

    val arrayString = listOf("Muhammad", "Rafi", "Triandi")
    arrayString.printElements()
}