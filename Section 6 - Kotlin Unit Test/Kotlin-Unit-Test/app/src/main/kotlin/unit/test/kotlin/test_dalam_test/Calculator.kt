package unit.test.kotlin.test_dalam_test

class Calculator {
    fun addition(x: Int, y: Int): Int {
        return x + y
    }

    fun subtraction(x: Int, y: Int): Int {
        return x - y
    }

    fun multiplication(x: Int, y: Int): Int {
        return x * y
    }

    fun division(x: Int, y: Int): Double {
        return x / y.toDouble()
    }
}