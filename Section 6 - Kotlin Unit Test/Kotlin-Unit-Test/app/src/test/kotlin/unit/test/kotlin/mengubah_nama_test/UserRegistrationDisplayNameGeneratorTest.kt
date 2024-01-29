package unit.test.kotlin.mengubah_nama_test

import org.junit.jupiter.api.*
import unit.test.kotlin.menggunakan_assertions.case1.UserRegistration
import unit.test.kotlin.menggunakan_assertions.case1.data.Register
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import unit.test.kotlin.utils.test_generator.SimpleDisplayNameGenerator
import kotlin.test.Test
import kotlin.test.*

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class UserRegistrationDisplayNameGeneratorTest {
    private val userRegistration = UserRegistration()

    @Test
    fun testRegisterSuccess() {
        val isSuccess = userRegistration.register(Register("triandy", "Testing193!"))
        assertTrue(isSuccess, "Registration should be successful.")
    }

    @Test
    fun testRegisterBlankUsername() {
        assertThrows<ValidationException> {
            userRegistration.register(Register("", "Testing193!"))
        }
    }

    @Test
    fun testRegisterWeakPassword() {
        assertThrows<ValidationException> {
            userRegistration.register(Register("john_doe", "123"))
        }
    }

    @Test
    fun testRegisterDuplicateUsername() {
        userRegistration.register(Register("alice", "SecurePassword193!"))

        assertThrows<ValidationException> {
            userRegistration.register(Register("alice", "NewPassword193!"))
        }
    }
}