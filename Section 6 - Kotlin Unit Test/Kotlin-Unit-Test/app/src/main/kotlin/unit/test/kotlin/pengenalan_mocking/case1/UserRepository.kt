package unit.test.kotlin.pengenalan_mocking.case1

interface UserRepository {
    fun saveUser(user: User): Boolean
    fun getAllUsers(): List<User>
}