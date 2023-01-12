package abstract_class

fun main() {
    // val location = Location() // Error: Cannot create an instance of an abstract class
    val city = City("Jakarta", "Bogor", "Depok", "Tangerang", "Bekasi")
    val country = Country("Indonesia")

    city.name.forEach(::println)
    country.name.forEach(::println)
}