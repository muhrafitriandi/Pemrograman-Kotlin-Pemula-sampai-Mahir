package star_projection

class Box<T>(val value: T)

fun printBoxValue(box: Box<*>) {
    val value = box.value
    println("Box value: $value")
}


fun main() {
    val stringBox = Box("Hello, World!")
    val intBox = Box(42)

    printBoxValue(stringBox)
    printBoxValue(intBox)
}