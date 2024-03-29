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
        else -> n * factorialRecursive(n - 1)
    }
}

// Independent Challenge

fun fibonacciLoop(n: Int): Int {
    var fn = 0
    var fn1 = 0
    var fn2 = 1
    for (i in 1 until n) {
        fn = fn1 + fn2
        fn1 = fn2
        fn2 = fn
    }
    return fn
}

fun fibonacciRecursive(n: Int): Int {
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }
}

fun main() {
    println(factorialLoop(5))
    println(factorialRecursive(5))

    println(fibonacciLoop(8))
    println(fibonacciRecursive(8))
}