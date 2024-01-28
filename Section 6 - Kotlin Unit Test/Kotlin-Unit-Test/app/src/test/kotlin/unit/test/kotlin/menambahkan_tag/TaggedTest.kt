package unit.test.kotlin.menambahkan_tag

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import kotlin.test.Test

@Tag("integration-test")
class TaggedTest {
    @Test
    fun testSlowOperation() {
        // Test logic for a slow operation
        println("Test Slow Operation")
        assertTrue(true)
    }

    @Test
    fun testFastUnitOperation() {
        // Test logic for a fast unit operation
        println("Test Fast Unit Operation")
        assertTrue(true)
    }


    @Test
    fun testIntegrationWithExternalSystem() {
        // Test logic for integration with an external system
        println("Test Integration With External System")
        assertTrue(true)
    }
}