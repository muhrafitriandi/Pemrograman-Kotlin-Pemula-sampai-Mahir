package equals_function

class Company(val name: String) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Company -> other.name == this.name
            else -> false
        }
    }
}