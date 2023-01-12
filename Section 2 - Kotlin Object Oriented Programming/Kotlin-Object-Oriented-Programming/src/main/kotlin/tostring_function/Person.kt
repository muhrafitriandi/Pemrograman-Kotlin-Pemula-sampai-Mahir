package tostring_function

class Person(val name: String, val age: Int, var address: String) {
    override fun toString(): String {
        return "Hello, my name is ${this.name}"
    }
}