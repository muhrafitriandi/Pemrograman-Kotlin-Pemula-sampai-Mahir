package abstract_properties_dan_function

abstract class Animal(val name: String) {
    abstract val species: String
    abstract fun sound()
}

class Cat(name: String, override val species: String): Animal(name) {

    override fun sound() {
        println("$name is $species Cat, his voice Meow!")
    }

}

class Dog(name: String, override val species: String): Animal(name) {
    override fun sound() {
        println("$name is $species Dog, his voice Guk! Guk!")
    }

}