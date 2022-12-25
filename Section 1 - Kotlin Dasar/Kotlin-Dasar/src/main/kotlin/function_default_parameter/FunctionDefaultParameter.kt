package function_default_parameter

fun sayHello(firstName: String, lastName: String? = null) {
    println("Hello $firstName ${lastName ?: ""}")
}
fun main() {
    sayHello("Muhammad Rafi", "Triandi")
    sayHello("Cristiano", "Ronaldo")
    sayHello("Madun")
}