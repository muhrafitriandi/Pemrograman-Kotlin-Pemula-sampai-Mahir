package unit.test.kotlin.mocking_di_test

import java.util.UUID

class PersonService(
    private val personRepository: PersonRepository,
) {
    fun getPersonById(id: String): Person {
        val person = personRepository.selectedById(id)
        if (id.isBlank()) throw BlankException("Person id is not blank")
        if (person == null) throw NullException("Person Not Found")

        return person
    }

    fun addPersonToDatabase(name: String): Person {
        val person = Person(UUID.randomUUID().toString(), name)
        if (name.isBlank()) throw BlankException("Person name is not blank")
        personRepository.savePerson(person)

        return person
    }
}

class BlankException(message: String) : Throwable(message)

class NullException(message: String) : Throwable(message)