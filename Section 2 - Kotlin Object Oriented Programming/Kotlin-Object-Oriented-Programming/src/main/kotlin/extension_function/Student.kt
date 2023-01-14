package extension_function

class Student(var name: String, private val nim: Int)

fun Student.greet() {
    println("My name is ${this.name} with nim")
    // ${this.nim} // error, because private
}