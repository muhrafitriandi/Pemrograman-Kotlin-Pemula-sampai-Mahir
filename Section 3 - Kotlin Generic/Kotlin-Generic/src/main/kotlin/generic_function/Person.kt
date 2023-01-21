package generic_function

class Person(val name: String) {
    fun <T> sayHello(friend: T) {
        println("Hello $friend, my name is ${this.name}")
    }
}