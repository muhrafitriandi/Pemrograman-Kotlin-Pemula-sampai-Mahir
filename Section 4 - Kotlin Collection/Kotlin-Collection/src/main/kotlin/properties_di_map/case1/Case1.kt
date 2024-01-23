package properties_di_map.case1

import properties_di_map.data.Application

fun main() {
    val map = mapOf(
        // "info" to "Belajar Kotlin", // key "info" not present, default null
        "name" to "Belajar Kotlin",
        "version" to 1
    )

    val app = Application(
        name = map["name"] as? String ?: "Default Name",
        version = map["version"] as? Int ?: 0
    )

    println(app.name)
    println(app.version)
}
