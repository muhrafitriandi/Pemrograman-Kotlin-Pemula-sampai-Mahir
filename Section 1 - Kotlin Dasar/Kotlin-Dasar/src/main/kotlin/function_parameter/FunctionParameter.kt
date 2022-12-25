package function_parameter

fun sayHello(firstName: String, lastName: String?) {
    println("Hello $firstName ${lastName ?: ""}")
}
fun main() {
    sayHello("Muhammad Rafi", "Triandi")
    sayHello("Cristiano", "Ronaldo")
    sayHello("Madun", null)
}