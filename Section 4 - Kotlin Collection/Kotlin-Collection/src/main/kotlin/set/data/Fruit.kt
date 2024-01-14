package set.data

class Fruit(val name: String, val color: String) {
    override fun hashCode(): Int {
        return name.hashCode() + color.hashCode()
    }

    override fun equals(other: Any?): Boolean = when (other) {
        is Fruit -> (name == other.name) && (color == other.color)
        else -> false
    }

    override fun toString(): String {
        return "$name - $color"
    }
}