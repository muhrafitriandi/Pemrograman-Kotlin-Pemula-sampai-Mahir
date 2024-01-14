package set

import set.data.Fruit

fun main() {
    // Membuat sebuah Set
    val fruitMutableSet: MutableSet<Fruit> = mutableSetOf(
        Fruit("apel", "merah"),
        Fruit("jeruk", "kuning"),
        Fruit("anggur", "ungu"),
        Fruit("pisang", "kuning"),
        Fruit("jeruk", "kuning"),
        Fruit("anggur", "hijau")
    )

    // iterator: Mendapatkan iterator untuk traversing set
    val iterator = fruitMutableSet.iterator()
    while (iterator.hasNext()) {
        println("Iterator: ${iterator.next()}")
    }

    // add: Menambahkan elemen ke dalam set
    fruitMutableSet.add(Fruit("mangga", "hijau"))
    println("Setelah tambah mangga: $fruitMutableSet")

    // remove: Menghapus elemen dari set
    fruitMutableSet.remove(Fruit("anggur", "hijau"))
    println("Setelah hapus anggur: $fruitMutableSet")

    // addAll: Menambahkan semua elemen dari koleksi lain ke dalam set
    val additionalFruits = setOf(Fruit("kiwi", "coklat"), Fruit("strawberry", "pink"))
    fruitMutableSet.addAll(additionalFruits)
    println("Setelah tambah semua buah tambahan: $fruitMutableSet")

    // removeAll: Menghapus semua elemen yang ada di dalam koleksi lain
    val fruitsToRemove = setOf(Fruit("mangga", "hijau"), Fruit("kiwi", "coklat"))
    fruitMutableSet.removeAll(fruitsToRemove)
    println("Setelah hapus mangga dan kiwi: $fruitMutableSet")

    // retainAll: Menyimpan hanya elemen-elemen yang ada di dalam koleksi lain
    val fruitsToRetain = setOf(Fruit("apel", "merah"), Fruit("pisang", "kuning"))
    fruitMutableSet.retainAll(fruitsToRetain)
    println("Setelah menyimpan hanya apel dan pisang: $fruitMutableSet")

    // clear: Menghapus semua elemen dari set
    fruitMutableSet.clear()
    println("Setelah membersihkan set: $fruitMutableSet")
}