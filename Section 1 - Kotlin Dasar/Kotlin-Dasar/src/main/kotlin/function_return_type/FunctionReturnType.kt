package function_return_type

fun sum(x: Double, y: Double): Double {
    return x.plus(y)
}

fun subtraction(x: Double, y: Double): Double {
    return x.minus(y)
}

fun multiplication(x: Double, y: Double): Double {
    return x.times(y)
}

fun division(x: Double, y: Double): Double {
    return if (x == 0.0 || y == 0.0 ) {
        0.0
    } else {
        x.div(y)
    }
}

fun modulo(x: Double, y: Double): Double {
    return x.mod(y)
}

fun main() {
    println("===SUM===")
    println(sum(x = 10.0, y = 20.0))
    println(sum(x = 10.5, y = 20.0))

    println()

    println("===SUBTRACTION===")
    println(subtraction(x = 20.0, y = 10.0))
    println(subtraction(x = 10.0, y = 0.0))

    println()

    println("===MULTIPLICATION===")
    println(multiplication(x = 20.0, y = 10.0))
    println(multiplication(x = 10.5, y = 20.0))

    println()

    println("===DIVISION===")
    println(division(x = 20.0, y = 10.0))
    println(division(x = 10.0, y = 0.0))

    println()

    println("===MODULO===")
    println(modulo(x = 10.0, y = 20.0))
    println(modulo(x = 10.0, y = 0.0))
}