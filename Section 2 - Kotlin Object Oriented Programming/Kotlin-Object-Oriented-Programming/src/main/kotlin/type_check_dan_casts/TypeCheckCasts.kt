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

fun main() {
    printObjectWithIf("Rafi")
    printObjectWithIf(1)
    printObjectWithIf(true)
    arrayOf(1, 2).forEach(::printObjectWithIf)
    printObjectWithIf(2.0)
    printObjectWithIf(Laptop("Asus"))
    printObjectWithIf(Smartphone("POCO M4 Pro", 2_800_000, "Android", 2022))
}