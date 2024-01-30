package unit.test.kotlin.mocking_di_test.manual

import org.junit.jupiter.api.*
import org.mockito.Mockito
import unit.test.kotlin.mocking_di_test.PersonRepository
import unit.test.kotlin.mocking_di_test.PersonService

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ParentMockingManualTest {
    private lateinit var personRepository: PersonRepository
    private var personService: PersonService? = null

    @BeforeAll
    fun setUp() {
        personRepository = Mockito.mock(PersonRepository::class.java)
        personService = PersonService(personRepository)

        println("Creating Person Service Object")
    }

    @AfterAll
    fun tearDown() {
        personService = null

        println("Destroyed Person Service Object")
    }

    fun getPersonService(): PersonService? {
        return personService
    }

    fun getPersonRepository(): PersonRepository {
        return personRepository
    }
}