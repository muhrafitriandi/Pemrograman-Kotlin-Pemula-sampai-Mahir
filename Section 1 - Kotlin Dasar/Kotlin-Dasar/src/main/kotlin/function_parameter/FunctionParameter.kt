package function_parameter

fun sayHello(firstName: String, lastName: String?) {
    val fullName = if (lastName != null) "$firstName $lastName" else firstName
    println("Hello, $fullName")
}

fun main() {
    sayHello("Muhammad Rafi", "Triandi")
    sayHello("Cristiano", "Ronaldo")
    sayHello("Madun", null)
}