package reflection

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

fun main() {
    
}