package unit.test.kotlin.pengenalan_mocking.case1

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserManagerTest: ParentUserManagerTest() {
    @Test
    fun testGetUserCount() {
        // Persiapkan data tiruan untuk dipanggil oleh metode getAllUsers()
        val fakeUsers = listOf(
            User(1, "Alice"),
            User(2, "Bob")
        )

        // Mengatur respons palsu untuk pemanggilan getAllUsers()
        Mockito.`when`(getUserRepository().getAllUsers()).thenReturn(fakeUsers)

        // Panggil metode yang akan diuji
        val userCount = getUserManager()!!.getUserCount()

        // Verifikasi bahwa metode getAllUsers() dipanggil sekali
        Mockito.verify(getUserRepository()).getAllUsers()

        // Periksa apakah hasil sesuai dengan harapan
        assertEquals(2, userCount)
    }

    @Test
    fun testAddUser() {
        // Persiapkan data tiruan untuk dipanggil oleh metode saveUser()
        val newUser = User(3, "Charlie")

        // Mengatur respons palsu untuk pemanggilan saveUser(newUser)
        Mockito.`when`(getUserRepository().saveUser(newUser)).thenReturn(true)

        // Panggil metode yang akan diuji
        val isUserSuccessAdded = getUserManager()!!.addUser(newUser)

        // Verifikasi bahwa metode saveUser() dipanggil sekali dengan newUser sebagai argumen
        Mockito.verify(getUserRepository()).saveUser(newUser)

        assertTrue(isUserSuccessAdded)
    }
}







































