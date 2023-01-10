package function_overriding

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

open class President(name: String) : Employee(name) {
    final override fun sayHello(name: String) {
        println("Hello $name, my president name is ${this.name}")
    }
}

class VicePresident(name: String) : President(name) {
//    Error: Because behaviour sayHello in President class is final
//    override fun sayHello(name: String) {
//        println("Hello $name my vice president name is ${this.name}")
//    }
}
