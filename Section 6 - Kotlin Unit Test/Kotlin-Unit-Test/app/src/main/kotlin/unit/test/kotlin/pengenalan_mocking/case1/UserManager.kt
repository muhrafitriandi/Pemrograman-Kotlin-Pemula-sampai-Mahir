package unit.test.kotlin.pengenalan_mocking.case1

class UserManager(
    private val userRepository: UserRepository,
) {
    fun getUserCount(): Int {
        return userRepository.getAllUsers().size
    }

    fun addUser(user: User): Boolean {
        return userRepository.saveUser(user)
    }
}