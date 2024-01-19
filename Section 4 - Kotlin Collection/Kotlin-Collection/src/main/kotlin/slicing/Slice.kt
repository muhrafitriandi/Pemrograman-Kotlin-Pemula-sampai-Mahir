package slicing

fun main() {
    val numbers = (1..100).toList()

    val slice1 = numbers.slice(49..99)
    println("Get Slicing Number 50-100: $slice1")

    val slice2 = numbers.slice(0..99 step 2)
    println("Get Slicing Odd Number 1-100: $slice2")

    val slice3 = numbers.slice(99 downTo 0 step 2)
    println("Get Slicing Even Number 1-100: ${slice3.reversed()}")

    val slice4 = numbers.slice(0..99 step 2)
    println("Get Slicing Odd Number 100-1: ${slice4.reversed()}")

    val slice5 = numbers.slice(99 downTo 0 step 2)
    println("Get Slicing Even Number 100-1: $slice5")
}