package generic_class

fun main() {
    val intValue: MyGenericClass<Int> = MyGenericClass<Int>(100)
    val stringValue: MyGenericClass<String> = MyGenericClass<String>("Rafi")

    intValue.printData()
    println(intValue.getData()) // will automatically be int without cast
    stringValue.printData()
    println(stringValue.getData()) // will automatically be string without cast
}