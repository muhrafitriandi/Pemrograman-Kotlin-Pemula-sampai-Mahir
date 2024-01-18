package collection_operations

fun main() {
    listOf("Muhammad", "Rafi", "Triandi").forEach {
        println(it)
    }

    mutableListOf("Muhammad", "Rafi", "Triandi").forEach {
        println(it)
    }

    setOf("Muhammad", "Rafi", "Rafi", "Triandi").forEach {
        println(it)
    }

    mutableSetOf("Muhammad", "Rafi", "Rafi", "Triandi").forEach {
        println(it)
    }

    mapOf("Muhammad" to 23).forEach {
        println(it)
    }

    mutableMapOf("Muhammad" to 23).forEach {
        println(it)
    }
}