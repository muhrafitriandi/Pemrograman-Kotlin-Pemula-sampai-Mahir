package lambda_expression

fun main() {
    // Lambda Expression in Variable with 2 Parameters
    val sum = { x: Int, y: Int -> x.plus(y) }
    println(sum(1, 2))

    // Lambda Expression It (It represents the first parameter (the object being processed))
    val gender: (String) -> String = { it.uppercase() }
    println(gender("Male"))

    // Lambda Expression, Method References
    val multiplication = ::multiplication
    println(multiplication(2, 3))

    // Lambda Expression, Parameter Function (Higher-Order Function)
    val result = processNumbers(2, 5) { x, y -> x.times(y) }
    println(result)
}

fun processNumbers(x: Int, y: Int, action: (Int, Int) -> Int): Int = action(x, y)

fun multiplication(x: Int, y: Int): Int = x.times(y)