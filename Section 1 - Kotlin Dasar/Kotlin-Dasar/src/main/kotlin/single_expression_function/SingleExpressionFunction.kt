package single_expression_function

fun calculateArea(length: Int, width: Int) = length * width
fun sayHello(name: String) = println("Hello $name")
fun main() {
    sayHello("Rafi")
    println("${calculateArea(6, 2)} cm")
}