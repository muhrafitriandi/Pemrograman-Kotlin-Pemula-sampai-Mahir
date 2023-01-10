package function_overloading

class Person {
    fun greet(name: String) {
        println("Hello, $name")
    }

    fun greet(name: String, age: Int) {
        println("Hello, $name. You are $age years old.")
    }
}