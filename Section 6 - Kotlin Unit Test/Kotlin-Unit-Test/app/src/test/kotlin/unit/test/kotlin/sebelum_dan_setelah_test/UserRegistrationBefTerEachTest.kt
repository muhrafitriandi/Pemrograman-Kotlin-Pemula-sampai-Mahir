package unit.test.kotlin.sebelum_dan_setelah_test

import org.junit.jupiter.api.*
import unit.test.kotlin.menggunakan_assertions.case1.UserRegistration
import unit.test.kotlin.menggunakan_assertions.case1.data.Register
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import kotlin.test.*
import kotlin.test.Test

class UserRegistrationBefTerEachTest {
    private lateinit var userRegistration: UserRegistration

    @BeforeEach
    fun setUp() {
        // Inisialisasi objek atau persiapan lain sebelum setiap pengujian
        userRegistration = UserRegistration()
        println("Set up UserRegistration.")
    }

    @AfterEach
    fun tearDown() {
        // Membersihkan sumber daya atau melakukan tugas pembersihan setelah setiap pengujian
        // Contoh: Menutup koneksi database, membersihkan file sementara, dll.
        println("Tear down UserRegistration.")
    }

    @Test
    fun testRegisterSuccess() {
        println("testRegisterSuccess")
        val isSuccess = userRegistration.register(Register("triandy", "Testing193!"))
        assertTrue(isSuccess, "Registration should be successful.")
    }

    @Test
    fun testRegisterBlankUsername() {
        println("testRegisterBlankUsername")
        assertThrows<ValidationException> {
            userRegistration.register(Register("", "Testing193!"))
        }
    }

    @Test
    fun testRegisterWeakPassword() {
        println("testRegisterWeakPassword")
        assertThrows<ValidationException> {
            userRegistration.register(Register("john_doe", "123"))
        }
    }

    @Test
    fun testRegisterDuplicateUsername() {
        println("testRegisterDuplicateUsername")
        userRegistration.register(Register("alice", "SecurePassword193!"))

        assertThrows<ValidationException> {
            userRegistration.register(Register("alice", "NewPassword193!"))
        }
    }
}