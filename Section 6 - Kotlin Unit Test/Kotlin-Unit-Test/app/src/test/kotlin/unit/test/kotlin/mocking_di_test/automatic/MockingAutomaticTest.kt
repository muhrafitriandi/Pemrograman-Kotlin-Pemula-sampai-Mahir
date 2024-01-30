package unit.test.kotlin.mocking_di_test.automatic

import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import unit.test.kotlin.mocking_di_test.Person
import kotlin.test.Test
import kotlin.test.assertEquals

class MockingAutomaticTest : ParentMockingAutomaticTest() {
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
}