package unit.test.kotlin.dependency_injection_di_test

import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.extension.*
import unit.test.kotlin.test_dalam_test.Calculator
import unit.test.kotlin.utils.resolver.RandomParameterResolver
import java.util.*
import kotlin.test.Test
import kotlin.test.*

@Extensions(
    value = [
        ExtendWith(RandomParameterResolver::class)
    ]
)
class RandomCalculatorTest {

    private val calculator = Calculator()

    @Test
    fun testAddition(random: Random, testInfo: TestInfo) {
        val first = random.nextInt(10)
        val second = random.nextInt(10)

        val result = calculator.addition(first, second)
        println("$first + $second = $result")
        println("Call ${testInfo.testMethod.get().name}")

        assertEquals((first + second), result)
    }
}