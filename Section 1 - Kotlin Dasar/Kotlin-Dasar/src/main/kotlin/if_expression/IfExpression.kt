package if_expression

fun main() {
    val examValue = 85

    if (examValue > 90) {
        println("Master!")
    } else if (examValue > 80) {
        println("Good Job!")
    } else {
        println("Try Again")
    }
}