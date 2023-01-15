package delegation

interface Base {
    fun sayHello(name: String)
}

class MyBase : Base {
    override fun sayHello(name: String) {
        println("Hello $name")
    }
}