package anonymous_function

fun sayHello(): (String) -> String {
    return { firstName -> firstName.uppercase() }
}

fun main() {
    println(sayHello()("rafi"))

    val printEventNumber = fun(values: IntArray) {
        values.forEach { num ->
            val result = if (num % 2 == 0) {
                "$num is Even Number"
            } else {
                "$num is Odd Number"
            }
            println(result)
        }
    }

    val upper = fun(value: String): String = if (value.isBlank()) "Ups" else value.uppercase()
    println(upper("triandy"))

    printEventNumber(intArrayOf(1, 2, 3))
}