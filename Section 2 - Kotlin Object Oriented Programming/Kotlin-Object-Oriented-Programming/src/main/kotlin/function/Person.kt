package function

class Person(val name: String) {
    fun run() {
        println("$name is running")
    }

    fun walking() {
        println("$name is walking")
    }
}