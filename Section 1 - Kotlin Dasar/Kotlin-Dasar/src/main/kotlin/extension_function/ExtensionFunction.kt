package extension_function

import java.util.*

fun String.toCapitalized(): String = this.split(" ").joinToString(" ") { word ->
    word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun main() {
    val fullName = "muhammad rafi triandi".toCapitalized()
    println(fullName)

    // call extension function with lambda method references
    val name: String.() -> String = String::toCapitalized
    println(name("muhammad ikhsan"))
}