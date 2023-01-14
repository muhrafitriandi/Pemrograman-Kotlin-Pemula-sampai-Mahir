package extension_function

class Student(val firstName: String, val lastName: String?, private val nim: Int)

fun Student?.greet() {
    if (this != null) {
        this.lastName?.let {
            println("My name is ${this.firstName} ${this.lastName} with nim")
        } ?: run {
            println("My name is ${this.firstName} with nim")
        }
        // ${this.nim} // error, because private
    }
}