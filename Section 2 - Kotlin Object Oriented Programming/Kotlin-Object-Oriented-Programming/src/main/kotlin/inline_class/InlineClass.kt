package inline_class

@JvmInline
value class Email(val value: String) {
    fun toUpper(): String = this.value.uppercase()
}
// inline class deprecated: using @JvmInline value

fun main() {
    val email = Email("example@example.com")
    println(email.value)
    println(email.toUpper())
}