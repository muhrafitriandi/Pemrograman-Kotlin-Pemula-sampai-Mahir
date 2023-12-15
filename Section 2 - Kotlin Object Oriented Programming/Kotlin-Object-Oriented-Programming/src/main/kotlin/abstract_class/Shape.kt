package abstract_class

abstract class Shape(val name: String) {
    abstract fun getArea(): Double

    fun printName() {
        println("Shape name is ${this.name}")
    }
}

class Rectangle(
    name: String,
    private val width: Double,
    private val height: Double,
) : Shape(name) {
    override fun getArea(): Double {
        return this.width * this.height
    }
}

class Circle(
    name: String,
    private val radius: Double,
) : Shape(name) {
    override fun getArea(): Double {
        return Math.PI * this.radius * this.radius
    }
}