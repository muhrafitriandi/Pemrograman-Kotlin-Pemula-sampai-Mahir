package secondary_constructor

class Person(name: String, age: Int, address: String) {

    init {
        println("Person $name created")
    }

    constructor(name: String, age: Int): this(name, age, "") {
        println("Constructor 1")
    }

    constructor(name: String): this(name, 0) {
        println("Constructor 2")
    }
}