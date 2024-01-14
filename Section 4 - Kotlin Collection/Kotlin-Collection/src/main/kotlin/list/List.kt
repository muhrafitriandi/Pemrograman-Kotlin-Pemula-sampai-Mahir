package list

fun main() {
    // Membuat sebuah List
    val fruits = listOf("apel", "jeruk", "anggur", "pisang")

    // size: Mendapatkan jumlah elemen dalam list
    val size = fruits.size
    println("Jumlah elemen dalam list: $size")

    // isEmpty: Memeriksa apakah list kosong
    val isEmpty = fruits.isEmpty()
    println("Apakah list kosong: $isEmpty")

    // isNotEmpty: Memeriksa apakah list tidak kosong
    val isNotEmpty = fruits.isNotEmpty()
    println("Apakah list tidak kosong: $isNotEmpty")

    // contains: Memeriksa apakah list mengandung suatu elemen
    val containsBanana = fruits.contains("pisang")
    println("Apakah list mengandung pisang: $containsBanana")

    // iterator: Mendapatkan iterator untuk traversing list
    val iterator = fruits.iterator()
    while (iterator.hasNext()) {
        println("Iterator: ${iterator.next()}")
    }

    // containsAll: Memeriksa apakah list mengandung semua elemen dari koleksi lain
    val fruitsToCheck = listOf("apel", "anggur")
    val containsAllFruits = fruits.containsAll(fruitsToCheck)
    println("Apakah list mengandung semua buah: $containsAllFruits")

    // get: Mendapatkan elemen pada indeks tertentu
    val elementAtIndex = fruits[2]
    println("Elemen pada indeks 2: $elementAtIndex")

    // indexOf: Mendapatkan indeks dari elemen pertama yang ditemukan
    val indexOfGrape = fruits.indexOf("anggur")
    println("Indeks dari anggur: $indexOfGrape")

    // lastIndexOf: Mendapatkan indeks dari elemen terakhir yang ditemukan
    val lastIndexOfGrape = fruits.lastIndexOf("anggur")
    println("Indeks terakhir dari anggur: $lastIndexOfGrape")

    // listIterator: Mendapatkan iterator untuk traversing list
    val listIterator = fruits.listIterator()
    while (listIterator.hasNext()) {
        println("List Iterator: ${listIterator.next()}")
    }

    // listIterator(param): Mendapatkan iterator dimulai dari indeks tertentu
    val listIteratorFromIndex = fruits.listIterator(1)
    while (listIteratorFromIndex.hasNext()) {
        println("List Iterator dari indeks 1: ${listIteratorFromIndex.next()}")
    }

    // sublist: Mendapatkan sublist dari list
    val subList = fruits.subList(1, 3)
    println("Sublist dari indeks 1 hingga 2: $subList")

    fruits.forEach {
        println(it)
    }
}