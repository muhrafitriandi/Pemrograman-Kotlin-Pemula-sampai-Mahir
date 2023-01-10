package this_keyword

class Person(val name: String, val age: Int) {
    fun greet(name: String) {
        println("Hello $name, nice to meet you! My name is ${this.name} ${this.age} years old.")
    }
}