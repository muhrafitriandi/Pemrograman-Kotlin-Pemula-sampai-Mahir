package operasi_boolean

fun main() {
    val finalExam = 80
    val attendant = 75

    val isPassFinalExam = finalExam > 75
    val isPassAttendant = attendant > 80

    val result = isPassFinalExam && isPassAttendant
    println(result)

    println(!result)
}