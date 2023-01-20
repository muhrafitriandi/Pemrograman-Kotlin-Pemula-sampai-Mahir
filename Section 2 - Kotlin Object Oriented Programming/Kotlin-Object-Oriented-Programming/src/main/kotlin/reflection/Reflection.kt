package reflection

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

fun validateRequestManual(request: CreateCategoryRequest) {
    if (request.id == "") {
        throw ValidationException("id is blank")
    } else {
        throw ValidationException("name is blank")
    }
}

fun validateRequestManual(request: CreateProductRequest) {
    if (request.id == "") {
        throw ValidationException("id is blank")
    } else {
        throw ValidationException("name is blank")
    }
}

fun validateReflection(request: Any) {
    val clazz = request::class
    val properties = clazz.memberProperties

    // check @NotBlank annotation
    for (property in properties) {
        if (property.findAnnotation<NotBlank>() != null) {
            val value = property.call(request)
            if (value == "") {
                throw ValidationException("${property.name} is blank")
            }
        }
    }
}

fun main() {
    val request1 = CreateProductRequest("1", "Indomie", 2000)
    validateReflection(request1)

    val request2 = CreateCategoryRequest("F", "Food")
    validateReflection(request2)
}