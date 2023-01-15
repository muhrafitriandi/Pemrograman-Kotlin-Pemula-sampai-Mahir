package sealed_class

fun evaluate(shape: Shape) {
    return when (shape) {
        is Shape.Circle -> println("Circle area is ${3.14.times(shape.radius).times(shape.radius)}")
        is Shape.Rectangle -> println("Rectangle area is ${shape.length.times(shape.breadth)}")
        is Shape.Square -> println("Square area is ${shape.length.times(shape.length)}")
    }
}

fun main() {
    val circle = Shape.Circle(4.5f)
    val rectangle = Shape.Rectangle(4, 5)
    val square = Shape.Square(4)

    evaluate(circle)
    evaluate(rectangle)
    evaluate(square)
}