package unit.test.kotlin.pengenalan_mocking

import org.mockito.Mockito
import kotlin.test.Test
import kotlin.test.*

class MockingTest {
    @Test
    fun testMock() {
        val list = Mockito.mock(List::class.java)
        // val list = listOf("Muhammad", "Rafi", "Triandy") --> we don't need like this

        Mockito.`when`(list[0]).thenReturn("Muhammad")
        Mockito.`when`(list[1]).thenReturn("Rafi")
        Mockito.`when`(list[2]).thenReturn("Triandy")

        assertEquals("Muhammad", list[0])
        assertEquals("Rafi", list[1])
        assertEquals("Rafi", list[1])
        // assertEquals("Triandy", list[2])

        Mockito.verify(list)[0] // default: will be called one time
        Mockito.verify(list, Mockito.times(2))[0] // will error, because list[0] only called one time
        Mockito.verify(list, Mockito.times(2))[1] // will success, list[1] called multiple (second) time
        Mockito.verify(list)[2] // will error, because list[2] never be called
    }
}