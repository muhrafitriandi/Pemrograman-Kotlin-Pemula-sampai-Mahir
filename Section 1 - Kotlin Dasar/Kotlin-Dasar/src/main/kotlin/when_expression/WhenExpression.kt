package when_expression

fun main() {
    var finalExam = "A"
    // When Expression
    val result1 = when (finalExam) {
        "A" -> "Amazing"
        "B" -> "Good"
        "C" -> "Not Bad"
        "D" -> "Bad"
        else -> "Try Again"
    }
    println(result1)


    finalExam = "C"
    // When Expression Multiple Option
    val result2 = when (finalExam) {
        "A", "B", "C" -> "Pass"
        else -> "Not Pass"
    }
    println(result2)


    // When Expression In
    finalExam = "D"
    val passValues = arrayOf("A", "B", "C")
    val result3 = when (finalExam) {
        in passValues -> "Pass"
        else -> "Not Pass"
    }
    println(result3)


    // When Expression Is
    val result4 = when (finalExam) {
        is String -> "This is a String"
        else -> "This is not a String"
    }
    println(result4)


    // When Mark Variable (Without Variable)
    val examScore = 80
    val result5 = when {
        examScore > 90 -> "Amazing"
        examScore > 80 -> "Good"
        examScore > 70 -> "Not Bad"
        examScore > 60 -> "Bad"
        else -> "Try Again"
    }
    println(result5)
}