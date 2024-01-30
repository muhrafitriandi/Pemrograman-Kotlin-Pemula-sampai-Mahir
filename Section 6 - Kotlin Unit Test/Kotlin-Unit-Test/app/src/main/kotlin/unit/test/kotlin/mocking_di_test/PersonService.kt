package unit.test.kotlin.mocking_di_test

class PersonService(
    private val personRepository: PersonRepository,
) {
    fun getPersonById(id: String): Person {
        val person = personRepository.selectedById(id)
        if (id.isBlank()) throw BlankException("Person id is not valid")
        if (person == null) throw NullException("Person Not Found")

        return person
    }
}

class BlankException(message: String) : Throwable(message)

class NullException(message: String) : Throwable(message)