package unit.test.kotlin.menggunakan_assertions.case1.validate

import unit.test.kotlin.menggunakan_assertions.case1.annotation.AllowedRegex
import unit.test.kotlin.menggunakan_assertions.case1.annotation.NotBlank
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

fun validateNotBlank(request: Any) {
    val clazz = request::class
    val properties = clazz.declaredMemberProperties

    properties.forEach { property ->
        property.findAnnotation<NotBlank>()?.let {
            when (val value = property.call(request)) {
                is String -> if (value == "") throw ValidationException("${property.name} is blank")
            }
        }
    }
}

fun validateAllowedRegex(request: Any) {
    val clazz = request::class
    val properties = clazz.declaredMemberProperties

    properties.forEach { property ->
        property.findAnnotation<AllowedRegex>()?.let { annotation ->
            val regex = annotation.regex
            when (val value = property.call(request)) {
                is String -> if (!regex.toRegex().matches(value)) throw ValidationException("${property.name} is not a valid: $value")
            }
        }
    }
}