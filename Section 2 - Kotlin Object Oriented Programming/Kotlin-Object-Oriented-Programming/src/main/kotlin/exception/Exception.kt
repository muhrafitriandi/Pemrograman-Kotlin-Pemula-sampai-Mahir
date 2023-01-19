package exception

fun validatePassword(password: String?) {
    password!!.let {
        if (password.length <= 8) {
            throw InvalidPasswordException("Password is too short")
        } else {
            println("Your password is $password")
        }
    }
}

fun main() {
    try {
        validatePassword("Sl4met4lonso45")
        validatePassword(null) // Ini akan error, ketika error maka...
        // validatePassword("sl4met") // Ini akan error, ketika error maka...
        println("Testing") // Statement ini tidak akan dijalankan.
    } catch (error: InvalidPasswordException) {
        println("Sesuatu telah terjadi: ${error.message}")
    } catch (error: NullPointerException) {
        println("Password tidak boleh kosong")
    } finally {
        println("Program Selesai") // Statement ini akan selalu dijalankan, baik sukses maupun gagal
    }
}