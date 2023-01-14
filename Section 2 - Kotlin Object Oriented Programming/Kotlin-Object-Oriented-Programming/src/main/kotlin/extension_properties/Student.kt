package extension_properties

import extension_function.Student

val Student?.upperName: String
    get() = if (this != null) {
        lastName?.let {
            "${firstName.uppercase()} ${it.uppercase()}"
        } ?: run {
            firstName.uppercase()
        }
    } else {
        ""
    }