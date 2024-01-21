package fold_and_reduce

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

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

    // Menggunakan reduceRight untuk menjumlahkan semua elemen dalam list dari kanan ke kiri
    val sumReductRight = numbers.reduceRight { first, second ->
        println("$first + $second = ${first + second}")
        first + second
    }
    println("$sumReductRight")

    println()

    // Menggunakan foldRight untuk menjumlahkan semua elemen dalam list dari kanan ke kiri, dengan nilai awal 0
    val sumFoldRight = numbers.foldRight(0) { first, second ->
        println("$first + $second = ${first + second}")
        first + second
    }
    println("$sumFoldRight")

    println()

    // Menggunakan reduceIndexed untuk menjumlahkan elemen pada indeks genap
    val productOfEvenIndexed = numbers.reduceIndexed { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using reduceIndexed: $productOfEvenIndexed")

    println()

    // Menggunakan foldIndexed untuk menjumlahkan elemen pada indeks genap, dengan nilai awal 0
    val productOfEvenIndexedWithInitial = numbers.foldIndexed(0) { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using foldIndexed with initial value: $productOfEvenIndexedWithInitial")

    println()

    // Menggunakan reduceRightIndexed untuk menjumlahkan elemen pada indeks genap, dari kanan ke kiri
    val productOfEvenReduceRightIndexed = numbers.reduceRightIndexed { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using reduceRightIndexed: $productOfEvenReduceRightIndexed")

    println()

    // Menggunakan foldRightIndexed untuk menjumlahkan elemen pada indeks genap, dengan nilai awal 0, dari kanan ke kiri
    val productOfEvenFoldRightIndexed = numbers.foldRightIndexed(0) { index, first, second ->
        if (index % 2 == 0) {
            println("$first + $second = ${first + second}")
            first + second
        } else first
    }
    println("Product of even indexed elements using foldRightIndexed: $productOfEvenFoldRightIndexed")
}