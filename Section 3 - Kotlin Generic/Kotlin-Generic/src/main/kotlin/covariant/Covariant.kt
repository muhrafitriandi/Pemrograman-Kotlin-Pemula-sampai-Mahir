package covariant

fun main() {
    val covariantString: Box<String> = Box("Hello")
    val covariantAny: Box<Any> = covariantString

    println(covariantAny.getData())
}