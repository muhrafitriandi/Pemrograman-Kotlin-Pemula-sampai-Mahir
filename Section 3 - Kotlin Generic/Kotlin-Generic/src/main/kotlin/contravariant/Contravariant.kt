package contravariant

fun main() {
    val contravariantAny: Person<Any> = Person()
    val contravariantString: Person<String> = contravariantAny

    contravariantString.sayHello("Rafi")
}