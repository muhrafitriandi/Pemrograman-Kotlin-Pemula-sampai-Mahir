package properties_di_map

class Application(map: Map<String, Any>) {
    val name: String by map
    val version: Int by map
}

fun main() {
    val map = mapOf(
        // "info" to "Belajar Kotlin", // Exception, key `info` is missing
        "name" to "Belajar Kotlin",
        "version" to 1
    )

    val app = Application(map)
    println(app.name)
    println(app.version)
}

