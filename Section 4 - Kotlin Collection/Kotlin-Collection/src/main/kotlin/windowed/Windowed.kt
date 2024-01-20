package windowed

fun main() {
    val numbers = (1..10).toList()

    val windows1 = numbers.windowed(3, 1, false)
    println(windows1)

    val windows2 = numbers.windowed(3, 1, false) { it.sum() }
    println(windows2)

    val windows3 = numbers.windowed(3, 1, true)
    println(windows3)

    val windows4 = numbers.windowed(3, 1, true) { it.sum() }
    println(windows4)

    val windows5 = numbers.windowed(3, 2, false)
    println(windows5)

    val windows6 = numbers.windowed(3, 2, false) { it.sum() }
    println(windows6)

    val windows7 = numbers.windowed(3, 2, true)
    println(windows7)

    val windows8 = numbers.windowed(3, 2, true) { it.sum() }
    println(windows8)
}