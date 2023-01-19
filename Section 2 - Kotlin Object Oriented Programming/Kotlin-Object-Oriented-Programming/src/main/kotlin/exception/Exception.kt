package exception

fun validatePassword(password: String) {
    if (password.length <= 8) {
        throw InvalidPasswordException("Password is too short")
    } else {
        println("Your password is $password")
    }
}

fun main() {
    validatePassword("Sl4met4lonso45")
    validatePassword("sl4met")
}