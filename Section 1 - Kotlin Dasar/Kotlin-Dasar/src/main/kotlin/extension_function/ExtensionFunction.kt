package extension_function

import java.util.*

fun String.toCapitalized(): String = this.split(" ").joinToString(" ") { word ->
    word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun main() {
    val fullName = "muhammad rafi triandi".toCapitalized()
    println(fullName)
}