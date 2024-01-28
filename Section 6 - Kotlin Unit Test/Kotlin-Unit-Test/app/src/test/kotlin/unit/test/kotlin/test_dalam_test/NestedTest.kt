package unit.test.kotlin.test_dalam_test

import org.junit.jupiter.api.*
import kotlin.test.Test
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NestedTest {
    private var calculator: Calculator? = null

    @BeforeAll
    fun setUp() {
        calculator = Calculator()
        println("Object calculator created.")
    }

    @AfterAll
    fun tearDown() {
        calculator = null
        println("Object calculator destroyed.")
    }

    @Nested
    inner class AdditionTest {
        @Test
        @DisplayName("Adding two positive numbers")
        fun testAdditionSuccess() {
            val result = calculator!!.addition(2, 3)
            assertEquals(5, result, "The result should be 5")
        }
    }

    @Nested
    inner class SubtractionTest {
        @Test
        @DisplayName("Subtracting a positive number from another positive number")
        fun testSubtractionSuccess() {
            val result = calculator!!.subtraction(2, 5)
            Assertions.assertEquals(-3, result)
        }
    }
}