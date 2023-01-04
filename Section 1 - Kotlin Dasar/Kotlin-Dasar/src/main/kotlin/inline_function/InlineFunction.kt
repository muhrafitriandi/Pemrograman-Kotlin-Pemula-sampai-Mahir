package inline_function

fun helloFirstName(firstName: () -> String): String = "Hello ${firstName()}"

inline fun helloLastName(lastName: () -> String): String = "Hello ${lastName()}"

inline fun sayHello(firstName: () -> String, noinline lastName: () -> String): String =
    "Hello ${firstName()} ${lastName()}"

fun main() {
    for (i in 1..100) {
        println(helloFirstName { "Rafi" })
    }

    for (i in 1..100) {
        println(helloLastName { "Triandy" })
    }

    for (i in 1..100) {
        println(sayHello({ "Rafi" }, { "Triandy" }))
    }
}