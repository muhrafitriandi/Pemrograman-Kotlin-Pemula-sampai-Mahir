package list

fun main() {
    // Membuat sebuah MutableList
    val mutableList = mutableListOf("apel", "jeruk", "anggur", "pisang")

    // add: Menambahkan elemen ke dalam list
    mutableList.add("mangga")
    println("Setelah tambah mangga: $mutableList")

    // remove: Menghapus elemen dari list
    mutableList.remove("anggur")
    println("Setelah hapus anggur: $mutableList")

    // addAll: Menambahkan semua elemen dari koleksi lain ke dalam list
    val additionalFruits = listOf("kiwi", "strawberry")
    mutableList.addAll(additionalFruits)
    println("Setelah tambah semua buah tambahan: $mutableList")

    // removeAll: Menghapus semua elemen yang ada di dalam koleksi lain
    mutableList.removeAll(additionalFruits)
    println("Setelah hapus semua buah tambahan: $mutableList")

    // retainAll: Menyimpan hanya elemen-elemen yang ada di dalam koleksi lain
    val fruitsToRetain = listOf("apel", "pisang")
    mutableList.retainAll(fruitsToRetain)
    println("Setelah menyimpan hanya apel dan pisang: $mutableList")

    // clear: Menghapus semua elemen dari list
    mutableList.clear()
    println("Setelah membersihkan list: $mutableList")

    // set: Mengganti nilai elemen pada indeks tertentu
    mutableList.add("anggur")
    mutableList[0] = "melon"
    println("Setelah mengganti melon pada indeks 0: $mutableList")

    // removeAt: Menghapus elemen pada indeks tertentu
    mutableList.removeAt(0)
    println("Setelah hapus elemen pada indeks 0: $mutableList")

    // listIterator: Mendapatkan iterator untuk traversing list
    mutableList.add("anggur")
    mutableList.add("melon")
    mutableList.add("papaya")
    val iterator = mutableList.listIterator()
    while (iterator.hasNext()) {
        println("Iterator: ${iterator.next()}")
    }

    // subList: Mendapatkan sublist dari list
    val subList = mutableList.subList(1, 3)
    println("Sublist dari indeks 1 hingga 2: $subList")

    mutableList.forEach {
        println(it)
    }
}