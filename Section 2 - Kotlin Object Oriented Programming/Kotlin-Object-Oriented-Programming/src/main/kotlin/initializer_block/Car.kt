package initializer_block

class Car(val brand: String, var year: Int = 2020) {
    init {
        println("Car $brand created")
    }
}