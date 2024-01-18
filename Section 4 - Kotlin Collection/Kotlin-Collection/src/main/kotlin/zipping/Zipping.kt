package zipping

fun main() {
    val npms = listOf(1402019001, 1402019002, 1402019003)
    val names = listOf("Rafi", "Agung", "Aldi")

    val zip: List<Pair<Int, String>> = npms.zip(names)
    println(zip)

    val zipLambda: List<String> = npms.zip(names.map { it.length }) { npm, length ->
        "$npm ($length characters)"
    }
    println(zipLambda)
}