package abstract_class

fun main() {
    // val shape = Shape("Shape") // Error: Cannot create an instance of an abstract class
    val rectangle = Rectangle("Rectangle", 5.0, 3.0)
    val circle = Circle("Circle", 2.0)

    rectangle.printName()
    println("Rectangle area is ${rectangle.getArea()}")

    circle.printName()
    println("Circle area is ${circle.getArea()}")
}