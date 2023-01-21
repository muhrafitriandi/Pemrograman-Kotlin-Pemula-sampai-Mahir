package generic_class

fun main() {
    val intValue = MyGenericClass(100)
    val stringValue = MyGenericClass("Rafi")

    intValue.printData()
    println(intValue.getData()) // will automatically be int without cast
    stringValue.printData()
    println(stringValue.getData()) // will automatically be string without cast

    val intStringPair = Pair(1, "Satu")
    val stringDoublePair = Pair("Tiga Koma Empat Belas", 3.14)

    intStringPair.printData()
    stringDoublePair.printData()
}