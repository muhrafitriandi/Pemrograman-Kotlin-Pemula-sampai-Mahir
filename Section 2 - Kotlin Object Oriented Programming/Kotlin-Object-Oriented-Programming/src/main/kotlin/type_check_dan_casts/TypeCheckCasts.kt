package type_check_dan_casts

import any_class.Laptop
import any_class.Smartphone

fun printObject(any: Any) {
    println(any)
}

fun printObjectWithIf(any: Any) {
    val data = if (any is Laptop) {
        "Laptop with name ${any.name}"
    } else if (any is Smartphone) {
        "Handphone with name ${any.name}"
    } else {
        any
    }
    println(data)
}

fun printObjectWithWhen(any: Any) {
    val data = when (any) {
        is Laptop -> "Laptop with name ${any.name}"
        is Smartphone -> "Handphone with name ${any.name}"
        else -> any
    }
    println(data)
}

fun printStringUnsafe(any: Any) {
    val value = any as String
    println(value)
}

fun main() {
    printObjectWithWhen("Rafi")
    printObjectWithWhen(1)
    printObjectWithWhen(true)
    arrayOf(1, 2).forEach(::printObjectWithWhen)
    printObjectWithWhen(2.0)
    printObjectWithWhen(Laptop("Asus"))
    printObjectWithWhen(Smartphone("POCO M4 Pro", 2_800_000, "Android", 2022))

    printStringUnsafe("Triandy") // Success
    // printStringUnsafe(22) // ClassCastException
}