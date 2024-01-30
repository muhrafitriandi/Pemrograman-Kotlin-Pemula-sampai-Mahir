package unit.test.kotlin.mocking_di_test

interface PersonRepository {
    fun selectedById(id: String): Person?

    fun savePerson(person: Person)
}