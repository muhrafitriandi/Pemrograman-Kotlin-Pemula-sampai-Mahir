package unit.test.kotlin.pewarisan_di_test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.*
import unit.test.kotlin.test_dalam_test.Calculator
import unit.test.kotlin.utils.resolver.RandomParameterResolver

@Extensions(
    value = [
        ExtendWith(RandomParameterResolver::class)
    ]
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseCalculatorTest {
    private var calculator: Calculator? = null

    @BeforeAll
    fun setUp() {
        calculator = Calculator()
        println("Set up Calculator.")
    }

    @AfterAll
    fun tearDown() {
        calculator = null
        println("Destroyed Calculator.")
    }

    fun getCalculator(): Calculator? {
        return calculator
    }
}