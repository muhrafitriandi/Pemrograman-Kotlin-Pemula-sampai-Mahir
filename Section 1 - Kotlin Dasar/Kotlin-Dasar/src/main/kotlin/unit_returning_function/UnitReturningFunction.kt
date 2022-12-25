package unit_returning_function

// By default, this function will return Unit (if it does not return data).
fun isPassed(finalExam: Int) {
    val passed = if (finalExam >= 50) "Passed" else "Not Passed"
    println(passed)
}

fun main() {
    isPassed(50)
    isPassed(40)
}