package unit.test.kotlin.menggunakan_assumptions

import java.time.DayOfWeek
import java.time.LocalDate
import kotlin.test.Test
import org.junit.jupiter.api.Assumptions.*

class CancellingTest {
    private val days = listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)

    // Example: Conditionally run the test based on the day of the week
    @Test
    fun testOnWeekends() {
        assumeTrue(LocalDate.now().dayOfWeek in days)

        // Test logic for weekends
        println("Running on weekends")
    }

    @Test
    fun testForDev() {
        val dev = System.getenv()["PROFILE"]
        assumeTrue("DEV" == dev)

        println("Running test with dev")
    }
}