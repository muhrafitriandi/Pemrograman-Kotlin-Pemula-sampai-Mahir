package reflection

import reflection.annotation.AllowedRegex
import reflection.annotation.NotBlank
import reflection.data.Login
import reflection.data.Register
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