package unit.test.kotlin.membuat_test

import kotlin.test.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun testAddSuccess() {
        val result = calculator.add(10, 10)
    }
}