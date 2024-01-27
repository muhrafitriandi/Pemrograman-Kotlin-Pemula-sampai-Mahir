package unit.test.kotlin.test_generator

import org.junit.jupiter.api.DisplayNameGenerator
import java.lang.reflect.Method

class SimpleDisplayNameGenerator : DisplayNameGenerator {
    override fun generateDisplayNameForClass(testClass: Class<*>): String {
        return testClass.simpleName
    }

    override fun generateDisplayNameForNestedClass(testClass: Class<*>): String {
        return testClass.simpleName
    }

    override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
        return "Test ${testClass.simpleName.replace("Test", "")} - ${testMethod.name}"

    }
}