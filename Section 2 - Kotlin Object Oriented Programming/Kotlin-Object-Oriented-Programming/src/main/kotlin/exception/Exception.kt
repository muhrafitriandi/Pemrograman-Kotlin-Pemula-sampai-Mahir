package exception

fun validatePassword(password: String) {
    if (password.length <= 8) {
        throw InvalidPasswordException("Password is too short")
    } else {
        println("Your password is $password")
    }
}

fun main() {
    try {
        validatePassword("Sl4met4lonso45")
        validatePassword("sl4met") // Ini akan error, ketika error maka...
        println("Testing") // Statement ini tidak akan dijalankan.
    } catch (error: InvalidPasswordException) {
        println("Sesuatu telah terjadi: ${error.message}")
    }
}