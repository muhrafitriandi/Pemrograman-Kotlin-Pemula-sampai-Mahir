package generic_constraint

interface IWalk {
    fun walk()
}

open class Employee(val name: String) {
    open fun sayHello(name: String) {
        println("Hello $name, my name is ${this.name}")
    }
}

class Manager(name: String) : Employee(name) {
    override fun sayHello(name: String) {
        println("Hello $name, my manager name is ${this.name}")
    }
}

class VicePresident(name: String) : Employee(name), IWalk {
    override fun sayHello(name: String) {
        println("Hello $name, my vice president name is ${this.name}")
    }

    override fun walk() {
        println("I'm walking")
    }
}

// generic 1 parameter type
// class Company<T>(val employee: T) where T : Employee, T : IWalk

// generic 2 parameter type
class Company<T, U>(val employee: T) where T : Employee, U : IWalk