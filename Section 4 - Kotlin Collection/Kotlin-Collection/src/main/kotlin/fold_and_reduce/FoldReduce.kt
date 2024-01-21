package fold_and_reduce

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val words = listOf("Kotlin", "is", "awesome")

    // Menggunakan reduce untuk menjumlahkan semua elemen dalam list
    val sum = numbers.reduce { first, second ->
        println("$first + $second = ${first + second}")
        first + second
    }
    println("$sum")

    println()

    // Menggunakan fold untuk menjumlahkan semua elemen dalam list, dengan nilai awal 0
    val sumWithInitial = numbers.fold(0) { first, second ->
        println("$first + $second = ${first + second}")
        first + second
    }
    println("$sumWithInitial")

    println()

    // Menggunakan reduceRight untuk menggabungkan kata dari kanan ke kiri
    val reversedString = words.reduceRight { first, second -> "$second $first" }
    println("Reversed String using reduceRight: $reversedString")

    println()

    // Menggunakan foldRight untuk menggabungkan kata dari kanan ke kiri, dengan nilai awal "Text:"
    val reversedStringWithInitial = words.foldRight("Text:") { first, second -> "$second $first" }
    println("Reversed String using foldRight with initial value: $reversedStringWithInitial")

    println()

    // Menggunakan reduceIndexed untuk menjumlahkan elemen pada indeks genap
    val productOfOddIndexed = numbers.reduceIndexed { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using reduceIndexed: $productOfOddIndexed")

    println()

    // Menggunakan foldIndexed untuk menjumlahkan elemen pada indeks genap, dengan nilai awal 1
    val productOfEvenIndexedWithInitial = numbers.foldIndexed(1) { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using foldIndexed with initial value: $productOfEvenIndexedWithInitial")

    println()

    // Menggunakan reduceRightIndexed untuk menggabungkan kata dari kanan ke kiri dengan indeks
    val reversedStringWithIndex = words.reduceRightIndexed { index, first, second -> "$second $index:$first" }
    println("Reversed String with index using reduceRightIndexed: $reversedStringWithIndex")

    println()

    // Menggunakan foldRightIndexed untuk menggabungkan kata dari kanan ke kiri dengan indeks, dengan nilai awal "Text:"
    val reversedStringWithIndexAndInitial = words.foldRightIndexed("Text:") { index, first, second -> "$second $index:$first" }
    println("Reversed String with index using foldRightIndexed with initial value: $reversedStringWithIndexAndInitial")
}