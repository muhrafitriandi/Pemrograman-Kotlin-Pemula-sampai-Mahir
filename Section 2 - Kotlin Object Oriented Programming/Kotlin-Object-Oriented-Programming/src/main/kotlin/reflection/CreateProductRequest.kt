package reflection

data class CreateProductRequest(
    val id: String,
    val name: String,
    val price: Long
)

data class CreateCategoryRequest(
    val id: String,
    val name: String
)
