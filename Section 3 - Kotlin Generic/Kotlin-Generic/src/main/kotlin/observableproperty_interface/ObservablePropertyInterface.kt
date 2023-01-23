package observableproperty_interface

fun main() {
    val car = Car("Toyota", 2019)

    car.brand = "Wuling"
    println(car.brand)

    println()

    car.year = 2020
    println(car.year)

    println()

    car.owner = "Rafi"
    println(car.owner)

    println()

    car.description = "Description"
    println(car.description)

    println()

    car.other = "Other"
    println(car.other)
}
