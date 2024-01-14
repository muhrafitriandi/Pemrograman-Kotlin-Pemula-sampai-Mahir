package set

import set.data.Fruit

fun main() {
    // Membuat sebuah Set
    val fruitSet: Set<Fruit> = setOf(
        Fruit("apel", "merah"),
        Fruit("jeruk", "kuning"),
        Fruit("anggur", "ungu"),
        Fruit("pisang", "kuning"),
        Fruit("jeruk", "kuning"),
        Fruit("anggur", "hijau")
    )

    // size: Mendapatkan jumlah elemen dalam set
    val size = fruitSet.size
    println("Jumlah elemen dalam set: $size")

    // isEmpty: Memeriksa apakah set kosong
    val isEmpty = fruitSet.isEmpty()
    println("Apakah set kosong: $isEmpty")

    // contains: Memeriksa apakah set mengandung suatu elemen
    val containsBanana = fruitSet.contains(Fruit("pisang", "kuning"))
    println("Apakah set mengandung pisang: $containsBanana")

    // iterator: Mendapatkan iterator untuk traversing set
    val iterator = fruitSet.iterator()
    while (iterator.hasNext()) {
        println("Iterator: ${iterator.next()}")
    }

    // containsAll: Memeriksa apakah set mengandung semua elemen dari koleksi lain
    val fruitsToCheck = setOf(Fruit("apel", "merah"), Fruit("anggur", "hijau"))
    val containsAllFruits = fruitSet.containsAll(fruitsToCheck)
    println("Apakah set mengandung semua buah: $containsAllFruits")

    fruitSet.forEach {
        println(it)
    }
}