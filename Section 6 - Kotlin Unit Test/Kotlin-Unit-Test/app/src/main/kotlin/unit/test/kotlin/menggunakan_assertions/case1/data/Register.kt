package unit.test.kotlin.menggunakan_assertions.case1.data

import unit.test.kotlin.menggunakan_assertions.case1.annotation.AllowedRegex
import unit.test.kotlin.menggunakan_assertions.case1.annotation.NotBlank

data class Register(
    @NotBlank
    val username: String,

    @NotBlank
    @AllowedRegex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$")
    val password: String
)