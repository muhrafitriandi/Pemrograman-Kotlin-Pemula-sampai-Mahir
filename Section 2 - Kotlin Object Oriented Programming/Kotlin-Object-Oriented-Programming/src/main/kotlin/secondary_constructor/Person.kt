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

// Without Primary Constructor
//class Person {
//    var name: String = ""
//    var age: Int = 0
//    var address: String = ""
//    constructor(nameParam: String, ageParam: Int, addressParam: String) {
//        name = nameParam
//        age = ageParam
//        address = addressParam
//        println("Constructor 1")
//    }
//
//    constructor(nameParam: String, ageParam: Int) {
//        name = nameParam
//        age = ageParam
//        println("Constructor 2")
//    }
//
//    constructor(nameParam: String) {
//        name = nameParam
//        println("Constructor 3")
//    }
//}

// Note:
// Without Primary Constructor, it is not necessary to use this (to execute other constructors).
// Without Primary Constructor, the code will look messier, because we have to declare variables and give default values which are eventually replaced with the parameters in the secondary constructor.