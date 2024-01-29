package unit.test.kotlin.informasi_test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestInfo
import kotlin.test.Test

class TestInformation {
    @Test
    @DisplayName("Sample Test Display NameInfo")
    @Tag("sample-test-info")
    fun testWithTestInfo(testInfo: TestInfo) {
        println("Running test: ${testInfo.displayName}")
        println("Test class: ${testInfo.testClass.get().simpleName}")
        println("Test method: ${testInfo.testMethod.get().name}")
        println("Tags: ${testInfo.tags}")
    }
}