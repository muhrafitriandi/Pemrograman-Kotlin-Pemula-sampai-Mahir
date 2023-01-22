package contravariant

class Person<in T> {
    fun sayHello(name: T) { // tidak boleh return generic / T
        println("Hello $name")
    }
}