package random_order

fun main() {
    val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Grapes")

    // Mengacak urutan elemen dalam list
    val shuffledFruits1 = fruits.shuffled()
    val shuffledFruits2 = fruits.shuffled()

    println("Original order: $fruits")
    println("Shuffled order 1: $shuffledFruits1")
    println("Shuffled order 2: $shuffledFruits2")
}