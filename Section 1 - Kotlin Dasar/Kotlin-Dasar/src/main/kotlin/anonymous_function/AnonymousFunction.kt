package anonymous_function

fun sayHello(): (String) -> String {
    return { firstName -> firstName.uppercase() }
}

fun main() {
    println(sayHello()("rafi"))

    val checkEvenOddNumber = fun(values: IntArray) {
        values.forEach { num ->
            val checkResult = when {
                num % 2 == 0 -> "$num is Even"
                else -> "$num is Odd"
            }
            println(checkResult)
        }
    }

    val upper = fun(value: String): String = if (value.isBlank()) "Ups" else value.uppercase()
    println(upper("triandy"))

    checkEvenOddNumber(intArrayOf(1, 2, 3))
}