package operasi_matematika

fun main() {
    // Operator -> +, -, *, /, %
    // val result1 = 10 / 3
    // If need result with coma
    val result1 = 10.0 / 3.0

    val result2 = 10 + 10 / 2

    // Augmented Assignments -> +=, -=, *=, /=, %=
    var total = 0
    val barang1 = 100
    total += barang1
    val barang2 = 200
    total += barang2
    val barang3 = 300
    total += barang3

    println(result1)
    println(result2)
    println(total)

    // Unary Operator -> ++, --, -, +, !
    total++
    println(total)
}