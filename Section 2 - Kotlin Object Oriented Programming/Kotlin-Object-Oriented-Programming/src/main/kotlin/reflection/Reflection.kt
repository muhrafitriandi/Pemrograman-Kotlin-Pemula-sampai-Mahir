package reflection

import reflection.data.Dog
import reflection.data.Login
import reflection.data.Register
import kotlin.reflect.full.declaredMemberFunctions

fun main() {
    // error: birthdate is blank
    // val user1 = Register("Rafi", "", "triandy", "test@gmail.com", "Testing")

    // error: birthdate is not valid
    // val user1 = Register("Rafi", "2000-12-12f", "triandy", "test@@gmail.com", "Testing")

    // error: email is not valid
    // val user1 = Register("Rafi", "2000-12-12", "triandy", "test@@gmail.com", "Testing")

    // error: password is not valid
    // val user1 = Register("Rafi", "2000-12-12", "triandy", "test@gmail.com", "Testing")

    val user1 = Register("Rafi", "2000-12-12", "triandy", "test@gmail.com", "Testing193!")
    val user2 = Login("triandy@gmail.com", "12345")

    // validateRequestManual(user1)
    // validateRequestManual(user2)
    validateAuth(user1, ::validateNotBlank, ::validateAllowedRegex)
    println()
    validateAuth(user2, ::validateNotBlank)

    // declaredMemberFunctions: mengakses fungsi-fungsi yang dideklarasikan secara eksplisit di kelas tersebut
    // memberFunctions: mengakses semua fungsi yang dapat diakses, termasuk yang diwarisi dari kelas parent.
    Dog::class.declaredMemberFunctions.forEach {
        println(it.name)
    }
}