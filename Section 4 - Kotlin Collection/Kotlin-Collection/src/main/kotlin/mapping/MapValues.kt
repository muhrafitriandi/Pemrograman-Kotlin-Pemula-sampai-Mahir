package mapping

import mapping.data.Student

fun main() {
    val student: Map<Int, Student> = mapOf(
        1402019001 to Student("Alice",  80, 70),
        1402019002 to Student("Bob", 75, 70),
        1402019003 to Student("Charlie", 70, 55)
    )

    val studentPass = student.mapValues { (_, student) ->
        val (_, finalExam, attitudePoint) = student
        val finalResult = if (attitudePoint >= 60) finalExam + (attitudePoint/10) else finalExam
        if (finalResult >= 80) "Pass"
        else "Not Pass"
    }
    println(studentPass)
}