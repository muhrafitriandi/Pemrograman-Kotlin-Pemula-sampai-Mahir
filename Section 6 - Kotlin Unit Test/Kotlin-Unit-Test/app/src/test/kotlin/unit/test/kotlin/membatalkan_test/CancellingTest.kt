package unit.test.kotlin.membatalkan_test

import org.opentest4j.TestAbortedException
import java.time.DayOfWeek
import java.time.LocalDate
import kotlin.test.Test

class CancellingTest {
    private val days = listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)

    // Example: Conditionally run the test based on the day of the week
    @Test
    fun testOnWeekends() {
        if (LocalDate.now().dayOfWeek !in days) {
            throw TestAbortedException("Test skipped, applicable only on weekends.")
        }
        // Test logic for weekends
        println("Running on weekends")
    }

    @Test
    fun testForDev() {
        val dev = System.getenv()["PROFILE"]
        if ("DEV" != dev) {
            throw TestAbortedException("Test skipped, only dev can do this")
        }
        println("Running test with dev")
    }
}