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

interface MoveLeft {
    fun move() {
        println("Move Left")
    }
}

interface MoveRight {
    fun move() {
        println("Move Right")
    }
}

class Car(override val name: String) : Driveable, MoveLeft, MoveRight {
    override fun startEngine() {
        println("Start Engine ${this.name} Car")
    }

    override fun stopEngine() {
        println("Stop Engine ${this.name} Car")
    }

    override fun drive() {
        println("Driving ${this.name} Car")
    }

    override fun move() {
        super<MoveLeft>.move()
    }
}

class Motorcycle(override val name: String) : Driveable, MoveLeft, MoveRight {
    override fun startEngine() {
        println("Start Engine ${this.name} Motorcycle")
    }

    override fun stopEngine() {
        println("Stop Engine ${this.name} Motorcycle")
    }

    override fun drive() {
        println("Driving ${this.name} Motorcycle")
    }

    override fun move() {
        super<MoveRight>.move()
    }

}