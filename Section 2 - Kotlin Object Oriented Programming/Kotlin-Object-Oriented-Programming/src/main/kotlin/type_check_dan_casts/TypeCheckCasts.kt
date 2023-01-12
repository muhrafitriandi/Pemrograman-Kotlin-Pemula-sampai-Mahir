package type_check_dan_casts

import any_class.Laptop
import any_class.Smartphone

fun printObject(any: Any) {
    println(any)
}

fun main() {
    printObject("Rafi")
    printObject(1)
    printObject(true)
    arrayOf(1, 2).forEach(::printObject)
    printObject(2.0)
    printObject(Laptop("Asus"))
    printObject(Smartphone("POCO M4 Pro", 2_800_000, "Android", 2022))
}