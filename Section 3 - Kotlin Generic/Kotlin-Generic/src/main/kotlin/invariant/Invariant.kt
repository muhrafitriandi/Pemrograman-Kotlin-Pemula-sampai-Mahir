package invariant

fun main() {
    val boxString: Box<String> = Box("Hello")

    // val boxAny: Box<Any> = boxString // error=invariant, tidak boleh di substitusi ke child atau parent

    println(boxString.item)
}