package star_projection

fun displayLength(array: Array<*>) { // This is same as: fun <T> displayLength(array: Array<T>)
    for (i in array) {
        print("$i ")
    }
    println("Total array is ${array.size}")
}

fun main() {
    val intArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val stringArray: Array<String> = arrayOf("Muhammad", "Rafi", "Triandi")
    // val anyArray: Array<Any> = stringArray // error

    displayLength(intArray)
    displayLength(stringArray)
}