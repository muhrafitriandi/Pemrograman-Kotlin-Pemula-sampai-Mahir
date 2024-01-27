package unit.test.kotlin.mengubah_nama_test

import org.junit.jupiter.api.*
import unit.test.kotlin.menggunakan_assertions.case1.UserRegistration
import unit.test.kotlin.menggunakan_assertions.case1.data.Register
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import kotlin.test.Test
import kotlin.test.*

class UserRegistrationDisplayNameTest {
    private val userRegistration = UserRegistration()

    @Test
    @DisplayName("Test Registration Success")
    fun testRegisterSuccess() {
        val isSuccess = userRegistration.register(Register("triandy", "Testing193!"))
        assertTrue(isSuccess, "Registration should be successful.")
    }

    @Test
    @DisplayName("Test Registration with Blank Username")
    fun testRegisterBlankUsername() {
        assertThrows<ValidationException> {
            userRegistration.register(Register("", "Testing193!"))
        }
    }

    @Test
    @DisplayName("Test Registration with Weak Password")
    fun testRegisterWeakPassword() {
        assertThrows<ValidationException> {
            userRegistration.register(Register("john_doe", "123"))
        }
    }

    @Test
    @DisplayName("Test Registration with Duplicate Username")
    fun testRegisterDuplicateUsername() {
        userRegistration.register(Register("alice", "SecurePassword193!"))

        assertThrows<ValidationException> {
            userRegistration.register(Register("alice", "NewPassword193!"))
        }
    }
}