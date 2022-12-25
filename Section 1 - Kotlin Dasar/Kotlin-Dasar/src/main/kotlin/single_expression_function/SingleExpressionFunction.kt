package single_expression_function

fun calculateArea(length: Int, width: Int): Int = length * width
fun sayHello(name: String): Unit = println("Hello $name")
fun main() {
    sayHello("Rafi")
    println("${calculateArea(6, 2)} cm")
}