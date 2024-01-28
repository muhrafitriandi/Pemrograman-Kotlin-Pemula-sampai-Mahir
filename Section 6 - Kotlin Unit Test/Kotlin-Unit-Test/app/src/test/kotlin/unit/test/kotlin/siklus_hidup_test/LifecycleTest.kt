package unit.test.kotlin.siklus_hidup_test

import org.junit.jupiter.api.*
import unit.test.kotlin.menggunakan_assertions.case1.UserRegistration
import unit.test.kotlin.menggunakan_assertions.case1.data.Register
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import kotlin.test.Test
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LifecycleTest {
    private lateinit var userRegistration: UserRegistration
    private var counter = 0

    @BeforeAll
    fun setUp() {
        counter++
        // Inisialisasi objek atau persiapan lain sebelum semua pengujian dijalankan
        userRegistration = UserRegistration()
        println("Hashcode SetUp $counter is ${this.hashCode()}")
    }

    @AfterAll
    fun tearDown() {
        counter = 0
        // Membersihkan sumber daya atau melakukan tugas pembersihan setelah semua pengujian selesai
        // Contoh: Menutup koneksi database, membersihkan file sementara, dll.
        println("Hashcode Tear Down $counter is ${this.hashCode()}")
    }

    @Test
    fun testRegisterSuccess() {
        counter++
        val isSuccess = userRegistration.register(Register("triandy", "Testing193!"))
        assertTrue(isSuccess, "Registration should be successful.")
        println("Hashcode Test Register Success $counter is ${this.hashCode()}")
    }

    @Test
    fun testRegisterBlankUsername() {
        counter++
        assertThrows<ValidationException> {
            userRegistration.register(Register("", "Testing193!"))
        }
        println("Hashcode Test Register Blank Username $counter is ${this.hashCode()}")
    }

    @Test
    fun testRegisterWeakPassword() {
        counter++
        assertThrows<ValidationException> {
            userRegistration.register(Register("john_doe", "123"))
        }
        println("Hashcode Test Register Weak Password $counter is ${this.hashCode()}")
    }

    @Test
    fun testRegisterDuplicateUsername() {
        counter++
        userRegistration.register(Register("alice", "SecurePassword193!"))

        assertThrows<ValidationException> {
            userRegistration.register(Register("alice", "NewPassword193!"))
        }
        println("Hashcode Test Register Duplicate Username $counter is ${this.hashCode()}")
    }
}