package unit.test.kotlin.verifikasi_di_mocking

import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.exceptions.base.MockitoException
import unit.test.kotlin.mocking_di_test.BlankException
import unit.test.kotlin.mocking_di_test.Person
import unit.test.kotlin.mocking_di_test.automatic.ParentMockingAutomaticTest
import unit.test.kotlin.pengenalan_mocking.case1.User
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MockingVerification : ParentMockingAutomaticTest() {
    @Test
    fun testPersonBlankId() {
        // Mengatur respons palsu untuk pemanggilan selectedById("4")
        Mockito.`when`(getPersonRepository().selectedById("4")).thenReturn(Person("4", "Rafi"))

        // Menguji apakah getPersonById("1") melemparkan pengecualian
        assertThrows<Exception> {
            getPersonService()!!.getPersonById("")
        }

        // Memverifikasi bahwa pemanggilan selectedById("") terjadi selama pengujian
        Mockito.verify(getPersonRepository()).selectedById("")
    }

    @Test
    fun testPersonNotFound() {
        // Mengatur respons palsu untuk pemanggilan selectedById("4")
        Mockito.`when`(getPersonRepository().selectedById("4")).thenReturn(Person("4", "Rafi"))

        // Menguji apakah getPersonById("1") melemparkan pengecualian
        assertThrows<Exception> {
            getPersonService()!!.getPersonById("1")
        }

        // Memverifikasi bahwa pemanggilan selectedById("1") terjadi selama pengujian
        Mockito.verify(getPersonRepository()).selectedById("1")
    }


    @Test
    fun testFoundPersonById() {
        // Mengatur respons palsu untuk pemanggilan selectedById("4")
        Mockito.`when`(getPersonRepository().selectedById("4")).thenReturn(Person("4", "Rafi"))

        // Menguji apakah getPersonById("4") mengembalikan objek Person
        val getPersonById = getPersonService()!!.getPersonById("4")

        // Memverifikasi bahwa pemanggilan selectedById("4") terjadi selama pengujian
        Mockito.verify(getPersonRepository()).selectedById("4")

        // Memastikan bahwa objek Person yang dikembalikan sesuai dengan yang diharapkan
        assertEquals(Person("4", "Rafi"), getPersonById)
    }

    @Test
    fun testInsertPersonBlankName() {
        assertThrows<BlankException> {
            getPersonService()!!.addPersonToDatabase("")
        }
    }

    @Test
    fun testInsertPerson() {
        val newUser = getPersonService()!!.addPersonToDatabase("Rafi")
        assertEquals("Rafi", newUser.name)
        assertNotNull(newUser.id)

        Mockito.verify(getPersonRepository()).savePerson(Person(newUser.id, newUser.name))
    }
}