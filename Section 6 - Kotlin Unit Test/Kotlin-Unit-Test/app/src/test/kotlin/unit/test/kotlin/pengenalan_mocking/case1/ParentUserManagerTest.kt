package unit.test.kotlin.pengenalan_mocking.case1

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ParentUserManagerTest {
    private var userManager: UserManager? = null
    private lateinit var userRepository: UserRepository

    @BeforeAll
    fun setUp() {
        // Persiapkan objek tiruan (mock) untuk UserRepository
        userRepository = Mockito.mock(UserRepository::class.java)

        // Inisialisasi UserManager dengan objek tiruan UserRepository
        userManager = UserManager(userRepository)

        println("User Manager Created.")
    }

    @AfterAll
    fun tearDown() {
        userManager = null
        println("User Manager Destroyed.")
    }

    fun getUserManager(): UserManager? {
        return userManager
    }

    fun getUserRepository(): UserRepository {
        return userRepository
    }
}








































