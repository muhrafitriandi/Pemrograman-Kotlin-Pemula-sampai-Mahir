package reverse_order

fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    // Membalik urutan list
    val reversedNumbers = numbers.reversed()
    println("Original numbers: $numbers")
    println("Reversed numbers: $reversedNumbers")

    // Menghasilkan view reversed list menggunakan asReversed
    val reversedView = numbers.asReversed()
    println("Original numbers: $numbers")
    // Perubahan di dalam view akan mempengaruhi list asli
    reversedView[0] = 10
    println("Modified view: $reversedView")
    println("Original numbers after modification: $numbers")

}