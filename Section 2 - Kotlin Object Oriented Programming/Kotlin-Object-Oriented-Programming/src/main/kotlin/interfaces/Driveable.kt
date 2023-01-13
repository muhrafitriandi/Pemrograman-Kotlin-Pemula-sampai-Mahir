package interfaces

interface Driveable {
    val name: String
    fun startEngine()
    fun stopEngine()
    fun drive()
    fun honk() {
        println("Honk Honk")
    }
}

class Car(override val name: String) : Driveable {
    override fun startEngine() {
        println("Start Engine ${this.name} Car")
    }

    override fun stopEngine() {
        println("Stop Engine ${this.name} Car")
    }

    override fun drive() {
        println("Driving ${this.name} Car")
    }

}

class Motorcycle(override val name: String) : Driveable {
    override fun startEngine() {
        println("Start Engine ${this.name} Motorcycle")
    }

    override fun stopEngine() {
        println("Stop Engine ${this.name} Motorcycle")
    }

    override fun drive() {
        println("Driving ${this.name} Motorcycle")
    }

}