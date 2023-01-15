package enum_class

fun main() {
    val currentDirection = Direction.NORTH
    println(currentDirection)
    println(Direction.values().toList())

    // Direction.values().forEach(Direction::showDescription)
}