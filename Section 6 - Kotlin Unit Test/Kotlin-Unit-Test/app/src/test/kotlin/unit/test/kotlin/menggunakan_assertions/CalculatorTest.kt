package unit.test.kotlin.menggunakan_assertions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import kotlin.test.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun divideSuccess() {
        val result = calculator.divide(10, 2)
        assertEquals(5, result, "The result should be 5")
    }

    @Test
    fun divideFailure() {
        assertThrows<IllegalArgumentException> {
            calculator.divide(10, 0)
        }
    }
}