package chunked

fun main() {
    val numbers = (1..10).toList()

    // Memecah list angka menjadi chunk dengan ukuran 3
    val chunks = numbers.chunked(3)
    println("Chunks: $chunks")

    // Memecah list angka menjadi chunk dengan ukuran 3, dan menghitung jumlah elemen dalam setiap chunk
    val chunkedWithTransform = numbers.chunked(3) { chunk -> chunk.sum() }
    println("Chunked with transform: $chunkedWithTransform")
}