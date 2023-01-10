package super_keyword

open class Shape(open val corner: Int = -1)

open class Rectangle : Shape() {
    override val corner: Int = 4
}

class Triangle : Shape() {
    override val corner: Int = 3
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