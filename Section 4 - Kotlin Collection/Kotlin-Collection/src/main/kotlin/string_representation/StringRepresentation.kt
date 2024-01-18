package string_representation

fun main() {
    val names = listOf("Muhammad", "Rafi", "Triandi")

    val string1 = names.joinToString(" ", "|", "|")
    println(string1)

    val string2 = names.joinToString(" ", "|", "|") { it.uppercase() }
    println(string2)

    val builder = StringBuilder()
    names.joinTo(builder, " ", "|", "|") { it.uppercase() }
    names.joinTo(builder, " ", ">", "<") { it.uppercase() }
    names.joinTo(builder, " ", "@", "@") { it.uppercase() }
    println(builder.toString())
}