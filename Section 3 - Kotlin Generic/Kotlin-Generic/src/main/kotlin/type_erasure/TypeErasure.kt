package type_erasure

fun main() {
    val data1: MyClass<String> = MyClass("This is a class")
    val dataString: String = data1.getData()
    println(dataString)

    val data2: MyClass<Int> = data1 as MyClass<Int>
    // val dataInt: Int = data2.getData() // ClassCastException
    // println(dataInt)
}