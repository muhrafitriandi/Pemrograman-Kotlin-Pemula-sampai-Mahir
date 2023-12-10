package equals_function

class Company(val name: String, val address: String) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Company -> other.name == this.name || other.address == this.address
            else -> false
        }
    }

    override fun hashCode(): Int {
        return this.name.hashCode()
    }
}