package interfaces

interface Engine {
    fun startEngine()
    fun stopEngine()
}

interface Vehicle : Engine {
    val name: String

    fun honk() {
        println("Honk Honk")
    }
}

interface Driveable : Vehicle {
    fun drive()
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