package unit.test.kotlin.test_berdasarkan_kondisi

import org.junit.jupiter.api.condition.*
import kotlin.test.Test

class ConditionalTest {
    // Example: Conditionally run the test based on the operating system
    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.MAC])
    fun testWindowsOnly() {
        // Test logic for Windows & Mac
        println("Running on Windows & Mac")
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS, OS.MAC])
    fun testNotWindows() {
        // Test logic for non-Windows OS
        println("Running on non-Windows OS")
    }


    // Example: Conditionally run the test based on the Java Runtime Environment
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    fun testJava8() {
        // Test logic for Java 8
        println("Running on Java 8")
    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    fun testNotJava8() {
        // Test logic for non-Java 8 environment
        println("Running on non-Java 8 environment")
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_18, max = JRE.JAVA_20)
    fun testJava18To20() {
        // Test logic for Java 18-20 environment
        println("Running on Java 18-20 environment")
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_18, max = JRE.JAVA_20)
    fun testNotJava18To20() {
        // Test logic for non-Java 18-20 environment
        println("Running on non-Java 18-20 environment")
    }


    // Example: Conditionally run the test based on the System Properties
    @Test
    fun getProperty() {
        System.getProperties().forEach { (key, value) ->
            println("$key : $value")
        }
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    fun testIfSystemPropertyIs64Bit() {
        // Test logic for 64-bit system
        println("Running on a 64-bit system")
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    fun testIfNotOracleJava() {
        // Test logic for non-Oracle Java
        println("Running on a non-Oracle Java vendor")
    }

    @Test
    @EnabledIfSystemProperties(
        EnabledIfSystemProperty(named = "os.name", matches = "Windows.*"),
        EnabledIfSystemProperty(named = "java.specification.version", matches = "18")
    )
    fun testIfMultipleSystemPropertiesMatch() {
        // Test logic for specific system properties
        println("Running on Windows with Java 18")
    }

    @Test
    @DisabledIfSystemProperties(
        DisabledIfSystemProperty(named = "os.name", matches = "Windows.*"),
        DisabledIfSystemProperty(named = "java.specification.version", matches = "18")
    )
    fun testIfMultipleSystemPropertiesDoNotMatch() {
        // Test logic for when specific system properties do not match
        println("Running on non-Windows or non-Java 8 environment")
    }


    // Example: Conditionally run the test based on the Environment
    @Test
    fun getEnvironment() {
        System.getenv().forEach { (key, value) ->
            println("$key : $value")
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "production")
    fun testIfEnvironmentIsProduction() {
        // Test logic for when the environment variable is set to "production"
        println("Running in the production environment")
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "true")
    fun testIfTestEnvironmentVariableIsSet() {
        // Test logic for when the "TEST_ENV" environment variable is not set to "true"
        println("Running when TEST_ENV is not set to true")
    }

    @Test
    @EnabledIfEnvironmentVariables(
        EnabledIfEnvironmentVariable(named = "OS", matches = "Windows_NT"),
        EnabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    )
    fun testIfMultipleEnvironmentVariablesMatch() {
        // Test logic for when multiple environment variables match
        println("Running on Windows with AMD64 Processor")
    }

    @Test
    @DisabledIfEnvironmentVariables(
        DisabledIfEnvironmentVariable(named = "OS", matches = "Windows_NT"),
        DisabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = "AMD64")
    )
    fun testIfMultipleEnvironmentVariablesDoNotMatch() {
        // Test logic for when multiple environment variables do not match
        println("Running on non-Windows or AMD64 Processor")
    }
}