/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package core

import kotlin.test.Test
import kotlin.test.assertNotNull

class CoreModuleTest {
    @Test fun testCoreFunction() {
        val classUnderTest = CoreModule()
        assertNotNull(classUnderTest.coreFunction(), "app should have a core module function")
    }
}
