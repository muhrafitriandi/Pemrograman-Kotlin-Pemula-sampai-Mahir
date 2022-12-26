package function_scope

fun sayHello(name: String, password: String? = null) {
    println("Hello $name, your password is ${password ?: ""}")
}

fun main() {
    fun password(password: String): String = password
    sayHello("Rafi", password("kamunanyapasswordnyaapa123"))
}