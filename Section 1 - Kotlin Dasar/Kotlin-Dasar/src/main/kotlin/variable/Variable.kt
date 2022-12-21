package variable

const val APP = "Belajar Kotlin"
const val VERSION = "0.0.1"
fun main() {
    val firstName = "Muhammad"
    // Error, Because val is Immutable
    // firstName = "Rafi"

    var lastName = "Triandi"
    lastName = "Rafi Triandi"

    val gender: String? = null

    println(firstName)
    println(lastName)
    println(gender)

    // Error, Because Gender can be null
    // println(gender.length)

    // Correct way
    println(gender?.length)

    println(APP)
    println(VERSION)
}