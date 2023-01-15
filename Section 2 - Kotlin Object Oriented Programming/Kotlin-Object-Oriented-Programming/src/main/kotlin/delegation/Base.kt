package delegation

interface Base {
    fun sayHello(name: String)

    fun sayGoodbye(name: String)
}

class MyBase : Base {
    override fun sayHello(name: String) {
        println("Hello $name")
    }

    override fun sayGoodbye(name: String) {
        println("Goodbye $name")
    }
}

class MyBaseDelegationManual(val base: Base) : Base {
    override fun sayHello(name: String) {
        base.sayHello(name)
    }

    override fun sayGoodbye(name: String) {
        base.sayGoodbye(name)
    }

}

class MyBaseDelegation(val base: Base) : Base by base

class MyBaseDelegationCustom(val base: Base) : Base by base {
    override fun sayHello(name: String) {
        println("Hi $name")
    }
}