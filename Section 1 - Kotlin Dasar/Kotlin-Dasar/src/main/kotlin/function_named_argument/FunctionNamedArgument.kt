package function_named_argument

fun personalData(
    firstName: String,
    lastName: String? = null,
    age: Int,
    height: Int,
    weight: Int
) {
    val data = """
        Full Name: $firstName ${lastName ?: ""}
        Age: $age
        Height: $height
        Weight: $weight
    """.trimIndent()
    println(data)
}

fun homeAddress(
    streetName: String,
    city: String,
    country: String
) {
    val homeAddressData = """
        Street: $streetName,
        City: $city,
        Country: $country
    """.trimIndent()
    println(homeAddressData)
}

fun main() {
    // If still don't want parameter lastName to be filled, use named argument.
    personalData(
        firstName = "Muhammad Rafi",
        age = 22,
        height = 180,
        weight = 65
    )

    println()

    // Without named argument, The data must be in the order of the parameters.
    homeAddress(
        "Jl. Merbabu",
        "Jawa Tengah",
        "Indonesia"
    )

    println()

    // By using named argument, The data entered does not need to be in the order of the parameters.
    homeAddress(
        country = "Indonesia",
        city = "Jawa Tengah",
        streetName = "Jl. Merbabu"
    )
}