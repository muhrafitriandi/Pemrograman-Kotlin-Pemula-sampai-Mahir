package properties_overriding

open class Shape(open val corner: Int = -1)

open class Rectangle(final override val corner: Int = 4) : Shape(corner)

class Triangle(override val corner: Int = 3) : Shape(corner)

//class Oval(
//    Error: Because properties corner in Rectangle class is final
//    override val corner: Int
//) : Rectangle(corner)