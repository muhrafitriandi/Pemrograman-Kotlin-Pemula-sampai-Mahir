package interfaces

fun main() {
    val car = Car("Avanza")
    val motorcycle = Motorcycle("Vario")

    car.drive()
    car.honk()
    car.move()
    motorcycle.drive()
    motorcycle.honk()
    motorcycle.move()
}