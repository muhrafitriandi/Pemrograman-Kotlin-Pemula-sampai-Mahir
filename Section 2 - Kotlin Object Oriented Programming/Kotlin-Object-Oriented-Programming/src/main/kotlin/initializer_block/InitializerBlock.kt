package initializer_block

fun main() {
    val avanza = Car("Toyota", 2015)

    val almaz = Car("Wuling")
    almaz.year = 2019

    println(avanza.brand)
    println(avanza.year)

    println(almaz.brand)
    println(almaz.year)
}