package unit.test.kotlin.test_dengan_parameter

import unit.test.kotlin.pewarisan_di_test.BaseCalculatorTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.util.stream.Stream

class ParameterizedCalculatorTest : BaseCalculatorTest() {

    @DisplayName("Test Calculator Value Resource")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun testValueSource(value: Int, testInfo: TestInfo) {
        val result = getCalculator()!!.multiplication(value, value)
        println("$value * $value = $result")
        println(testInfo.displayName)

        assertEquals(value * value, result)
    }

//    @DisplayName("Test Calculator Enum Resource")
//    @ParameterizedTest(name = "{displayName} with data {0}")
//    @EnumSource(Operation::class)
//    fun testEnumSource(operation: Operation, testInfo: TestInfo) {
//        val result = getCalculator()!!.performOperation(10, 5, operation)
//        println(testInfo.displayName)
//
//        assertEquals(Operation.ADDITION. * value, result)
//    }

    @DisplayName("Test Calculator Method Resource")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @MethodSource("provideNumbers")
    fun testMethodSource(a: Int, b: Int, expected: Int, testInfo: TestInfo) {
        val result = getCalculator()!!.addition(a, b)
        println("$a + $b = $expected")
        println(testInfo.displayName)

        assertEquals(expected, result)
    }

    @DisplayName("Test Calculator CSV Source")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @CsvSource("1, 2, 3", "-1, 1, 0", "0, 0, 0", "5, 5, 10")
    fun testCsvSource(a: Int, b: Int, expected: Int, testInfo: TestInfo) {
        val result = getCalculator()!!.addition(a, b)
        println("$a + $b = $expected")
        println(testInfo.displayName)

        assertEquals(expected, result)
    }

//    @DisplayName("Test Calculator CSV File Source")
//    @ParameterizedTest(name = "{displayName} with data {0}")
//    @CsvFileSource(resources = ["/test-data.csv"], numLinesToSkip = 1)
//    fun testMultiplication(a: Int, b: Int, expected: Int) {
//        val result = getCalculator()!!.multiplication(a, b)
//        assertEquals(expected, result)
//    }

    @DisplayName("Test Calculator Arguments Source")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ArgumentsSource(CustomArgumentsProvider::class)
    fun testArgumentSource(a: Int, b: Int, expected: Double, testInfo: TestInfo) {
        val result = getCalculator()!!.division(a, b)
        println("$a / $b = $expected")
        println(testInfo.displayName)

        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun provideNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 1, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(5, 5, 10)
            )
        }
    }

    class CustomArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                Arguments.of(6, 2, 3.0),
                Arguments.of(10, 2, 5.0),
                Arguments.of(8, 4, 2.0)
            )
        }
    }
}