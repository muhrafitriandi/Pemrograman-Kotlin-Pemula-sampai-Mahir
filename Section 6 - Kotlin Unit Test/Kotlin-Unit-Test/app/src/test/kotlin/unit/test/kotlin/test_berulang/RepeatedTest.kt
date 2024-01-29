package unit.test.kotlin.test_berulang

import org.junit.jupiter.api.*
import org.junit.jupiter.api.RepeatedTest
import unit.test.kotlin.pewarisan_di_test.BaseCalculatorTest
import java.util.*
import kotlin.test.*

class RepeatedTest : BaseCalculatorTest() {
    @Nested
    inner class AdditionTest {
        @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
        )
        @DisplayName("Test Add Random")
        fun testAddition(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo) {
            val first = random.nextInt(10)
            val second = random.nextInt(10)

            val result = getCalculator()!!.addition(first, second)
            println("$first + $second = $result")
            println(testInfo.displayName)

            assertEquals((first + second), result)
        }
    }

    @Nested
    inner class SubtractionTest {
        @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
        )
        @DisplayName("Test Sub Random")
        fun testSubtraction(random: Random, repetitionInfo: RepetitionInfo, testInfo: TestInfo) {
            val first = random.nextInt(10)
            val second = random.nextInt(10)

            val result = getCalculator()!!.subtraction(first, second)
            println("$first - $second = $result")
            println(testInfo.displayName)

            assertEquals((first - second), result)
        }
    }
}