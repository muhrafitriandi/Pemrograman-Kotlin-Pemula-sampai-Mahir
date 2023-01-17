package lazy_properties

fun main() {
    val myClass = MyClass() // tidak akan dibuat object sampai myHeavyObject diakses pertama kali.
    println("Accessing myHeavyObject for the first time:")
    myClass.myHeavyObject // "Creating myHeavyObject!" will be printed
    println("Accessing myHeavyObject for the second time:")
    myClass.myHeavyObject // tidak akan dicetak karena object sudah dibuat sebelumnya.
}