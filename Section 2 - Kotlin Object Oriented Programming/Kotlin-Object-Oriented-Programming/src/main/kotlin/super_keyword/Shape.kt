package super_keyword

open class Shape(open val corner: Int = -1) {
    open fun print() {
        println("This is Shape")
    }
}

open class Rectangle : Shape() {
    override val corner: Int = 4
    override fun print() {
        println("This is Rectangle")
        super.print()
    }
}

class Triangle : Shape() {
    override val corner: Int = 3
    override fun print() {
        println("This is Triangle")
        super.print()
    }
    val parentCorner: Int = super.corner
}

//open class Rectangle : Shape() {
//    override val corner: Int = 4
//    open val parentCorner = super.corner
//}
//
//class Triangle : Rectangle() {
//    override val corner: Int = 3
//    // Get the corner properties in each parent
//    override val parentCorner: Int = super.parentCorner
//}