package observable_properties

fun main() {
    val student = Student("Rafi", 65)

    student.name = "Madun"
    student.name = "Rizal"
    student.name = "Mail"

    println()

    student.quiz = 70
    student.quiz = 75
    student.quiz = 65
    student.quiz = 50 // will not changed
    student.quiz = 30 // will not changed
}