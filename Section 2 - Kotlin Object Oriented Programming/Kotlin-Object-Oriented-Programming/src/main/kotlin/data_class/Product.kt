package data_class

data class PersonA(
    val name: String,
)

class PersonB(
    val name: String,
)

data class PersonC(
    val name: String,
) {
    var age = 22
}

data class Address(
    var city: String,
    var houseNo: String,
)

data class Person(
    val name: String,
    val gender: String,
    val address: Address,
) {
    var age = 24
}
