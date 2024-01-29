package unit.test.kotlin.pewarisan_di_test

import org.junit.jupiter.api.Nested
import java.util.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest : BaseCalculatorTest() {
    @Nested
    inner class AdditionTest {
        @Test
        fun testAddition(random: Random) {
            val first = random.nextInt(10)
            val second = random.nextInt(10)

            val result = getCalculator()!!.addition(first, second)
            println("$first + $second = $result")

            assertEquals((first + second), result)
        }
    }

    @Nested
    inner class SubtractionTest {
        @Test
        fun testSubtraction(random: Random) {
            val first = random.nextInt(10)
            val second = random.nextInt(10)

            val result = getCalculator()!!.subtraction(first, second)
            println("$first - $second = $result")

            assertEquals((first - second), result)
        }
    }
}