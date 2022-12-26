package return_if_dan_when

fun checkAge(age: Int): String {
    return if (age >= 18) "Adult" else "Kid"
}

fun dayOfWeek(day: Int): String {
    return when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid Day"
    }
}

fun main() {
    println(checkAge(22))
    println(checkAge(6))
    println(dayOfWeek(3))
    println(dayOfWeek(7))
    println(dayOfWeek(8))
}