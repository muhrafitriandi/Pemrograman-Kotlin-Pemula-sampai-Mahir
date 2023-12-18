package reflection.data

open class Animal {
    fun sound() {
        println("Sample Sound")
    }
}

class Dog : Animal() {
    fun walk() {
        println("Sample Walk")
    }
}
