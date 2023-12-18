package reflection

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

fun validateRequestManual(request: Register) {
    if (request.name == "") throw ValidationException("name is blank")
    if (request.birthdate == "") throw ValidationException("birthdate is blank")
    if (request.username == "") throw ValidationException("username is blank")
    if (request.email == "") throw ValidationException("email is blank")
    if (request.password == "") throw ValidationException("password is blank")
}

fun validateRequestManual(request: Login) {
    if (request.email == "") throw ValidationException("email is blank")
    if (request.password == "") throw ValidationException("password is blank")
}

fun validateNotBlank(request: Any) {
    val clazz = request::class
    val properties = clazz.declaredMemberProperties

    // check @NotBlank annotation
    properties.forEach { property ->
        property.findAnnotation<NotBlank>()?.let {
            when (val value = property.call(request)) { // get the actual value from property
                is String -> if (value == "") throw ValidationException("${property.name} is blank")
            }
        }
    }
}

fun validateAllowedRegex(request: Any) {
    val clazz = request::class
    val properties = clazz.declaredMemberProperties

    // check @AllowedRegex annotation
    properties.forEach { property ->
        property.findAnnotation<AllowedRegex>()?.let { annotation ->
            val regex = annotation.regex // get the expected value regex from property
            when (val value = property.call(request)) { // get the actual value from property
                is String -> if (!regex.toRegex().matches(value)) throw ValidationException("${property.name} is not a valid: $value")
            }
        }
    }
}

fun validateAuth(request: Any, vararg validators: (Any) -> Unit) {
    try {
        validators.forEach { it(request) }
        when (request) {
            is Register -> println(
                """
                Data Register:
                Name: ${request.name}
                Birthdate: ${request.birthdate}
                Username: ${request.username}
                Email: ${request.email}
                Password: ${request.password}
            """.trimIndent()
            )

            is Login -> println(
                """
                Data Login:
                Name: ${request.email}
                Password: ${request.password}
            """.trimIndent()
            )
        }
    } catch (e: ValidationException) {
        println("Validation error: ${e.message}")
    }
}

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