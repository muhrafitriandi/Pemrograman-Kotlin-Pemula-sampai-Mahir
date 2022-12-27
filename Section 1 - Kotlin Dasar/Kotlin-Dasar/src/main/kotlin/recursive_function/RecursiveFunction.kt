package recursive_function

fun factorialLoop(n: Int): Int {
    var result = 1
    for (i in n downTo 1) {
        result *= i
    }
    return result
}

fun factorialRecursive(n: Int): Int {
    return when (n) {
        1 -> 1
        else -> {
            val result: Int = n * factorialRecursive(n - 1)
            result
        }
    }
}

fun main() {
    println(factorialLoop(5))
    println(factorialRecursive(5))
}