package unit.test.kotlin.menggunakan_assertions

class Calculator {
    fun divide(x: Int, y: Int): Int {
        return if (y == 0) throw IllegalArgumentException("Cannot divide by zero")
        else x / y
    }
}