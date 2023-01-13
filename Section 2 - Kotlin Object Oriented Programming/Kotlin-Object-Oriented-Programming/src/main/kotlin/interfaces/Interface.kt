package interfaces

fun main() {
    val car = Car("Avanza")
    val motorcycle = Motorcycle("Vario")

    car.drive()
    car.honk()
    motorcycle.drive()
    motorcycle.honk()
}