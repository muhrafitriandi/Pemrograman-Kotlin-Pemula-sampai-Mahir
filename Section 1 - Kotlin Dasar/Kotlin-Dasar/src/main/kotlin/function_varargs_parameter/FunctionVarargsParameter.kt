package function_varargs_parameter

fun calculateQuizScore(name: String, vararg values: Int) {
    var sum = 0.0
    values.forEach {
        sum += it
    }
    val finalScore = sum.div(values.size)
    println("The final score for $name is $finalScore")
}

fun main() {
    calculateQuizScore("Rafi", 100, 75, 60)
}