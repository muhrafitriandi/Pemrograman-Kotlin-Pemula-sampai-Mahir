package polymorphism

fun main() {
    var shape: Shape = Rectangle() // must explicit type (Shape)
    shape.draw()

    shape = Circle()
    shape.draw()
}