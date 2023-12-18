package reflection.data

import reflection.annotation.AllowedRegex
import reflection.annotation.NotBlank

data class Register(
    @NotBlank
    val name: String,

    @NotBlank
    @AllowedRegex("\\d{4}-\\d{2}-\\d{2}")
    val birthdate: String,

    @NotBlank
    val username: String,

    @NotBlank
    @AllowedRegex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
    val email: String,

    @NotBlank
    @AllowedRegex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}\$")
    val password: String,
)

data class Login(
    @NotBlank
    val email: String,

    @NotBlank
    val password: String,
)