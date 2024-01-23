package set_spesific_opetaions

fun main() {
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(3, 4, 5, 6, 7)

    // Menggabungkan dua set
    val unionSet = set1.union(set2)
    println("Union Set: $unionSet")

    // Mengambil elemen yang ada di kedua set
    val intersectSet = set1.intersect(set2)
    println("Intersect Set: $intersectSet")

    // Mengambil elemen yang ada di set1 tetapi tidak ada di set2
    val subtractSet1 = set1.subtract(set2)
    println("Subtract Set 1: $subtractSet1")

    // Mengambil elemen yang ada di set2 tetapi tidak ada di set1
    val subtractSet2 = set2.subtract(set1)
    println("Subtract Set 2: $subtractSet2")
}