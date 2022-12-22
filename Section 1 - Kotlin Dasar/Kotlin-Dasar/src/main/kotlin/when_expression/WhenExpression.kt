package when_expression

fun main() {
    var finalExam = "A"
    // When Expression
    when (finalExam) {
        "A" -> println("Amazing")
        "B" -> println("Good")
        "C" -> println("Not Bad")
        "D" -> println("Bad")
        else -> println("Try Again")
    }

    finalExam = "C"
    // When Expression Multiple Option
    when (finalExam) {
        "A", "B", "C" -> println("Pass")
        else -> println("Not Pass")
    }

    // When Expression In
    finalExam = "D"
    val passValues = arrayOf("A", "B", "C")
    when (finalExam) {
        in passValues -> println("Pass")
        !in passValues -> println("Not Pass")
    }

    // When Expression Is
    when (finalExam) {
        is String -> println("This is a String")
        !is String -> println("This is not a String")
    }

    // When Mark Variable (Without Variable)
    val examScore = 80
    when {
        examScore > 90 -> println("Amazing")
        examScore > 80 -> println("Good")
        examScore > 70 -> println("Not Bad")
        examScore > 60 -> println("Bad")
        else -> println("Try Again")
    }
}