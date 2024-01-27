package unit.test.kotlin.menggunakan_assertions.case1

import unit.test.kotlin.menggunakan_assertions.case1.data.Register
import unit.test.kotlin.menggunakan_assertions.case1.exception.ValidationException
import unit.test.kotlin.menggunakan_assertions.case1.validate.validateAllowedRegex
import unit.test.kotlin.menggunakan_assertions.case1.validate.validateNotBlank

class UserRegistration {
    private val registeredUsers = mutableSetOf<Register>()

    fun register(register: Register): Boolean {
        validateNotBlank(register)
        validateAllowedRegex(register)

        registeredUsers.map { (username, _) ->
            if (username.contains(register.username)) {
                throw ValidationException("Username is already registered.")
            }
        }

        registeredUsers.add(register)
        return true
    }
}