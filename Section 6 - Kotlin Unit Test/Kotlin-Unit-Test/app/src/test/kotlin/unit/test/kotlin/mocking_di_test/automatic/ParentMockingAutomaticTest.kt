package unit.test.kotlin.mocking_di_test.automatic

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.*
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import unit.test.kotlin.mocking_di_test.PersonRepository
import unit.test.kotlin.mocking_di_test.PersonService

@Extensions(
    value = [
        ExtendWith(MockitoExtension::class)
    ]
)
open class ParentMockingAutomaticTest {
    @Mock
    private lateinit var personRepository: PersonRepository
    private var personService: PersonService? = null

    @BeforeEach
    fun setUp() {
        personService = PersonService(personRepository)

        println("Creating Person Service Object")
    }

    @AfterEach
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