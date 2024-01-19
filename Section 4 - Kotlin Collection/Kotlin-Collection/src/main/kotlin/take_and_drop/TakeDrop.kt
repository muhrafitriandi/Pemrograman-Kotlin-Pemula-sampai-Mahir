package take_and_drop

fun main() {
    val numbers = (1..10).toList()

    // Mengambil 3 elemen pertama
    val takeResult = numbers.take(3)
    println("Take 3 elements: $takeResult")

    // Mengambil 3 elemen terakhir
    val takeLastResult = numbers.takeLast(3)
    println("Take last 3 elements: $takeLastResult")

    // Mengambil elemen pertama selama kondisi terpenuhi
    val takeWhileResult = numbers.takeWhile { it < 5 }
    println("Take elements while less than 5: $takeWhileResult")

    // Mengambil elemen terakhir selama kondisi terpenuhi
    val takeWhileLastResult = numbers.takeLastWhile { it > 7 }
    println("Take last elements while greater than 7: $takeWhileLastResult")

    // Menghapus 3 elemen pertama
    val dropResult = numbers.drop(3)
    println("Drop first 3 elements: $dropResult")

    // Menghapus 3 elemen terakhir
    val dropLastResult = numbers.dropLast(3)
    println("Drop last 3 elements: $dropLastResult")

    // Menghapus elemen pertama selama kondisi terpenuhi
    val dropWhileResult = numbers.dropWhile { it < 5 }
    println("Drop elements while less than 5: $dropWhileResult")

    // Menghapus elemen terakhir selama kondisi terpenuhi
    val dropWhileLastResult = numbers.dropLastWhile { it > 7 }
    println("Drop last elements while greater than 7: $dropWhileLastResult")

}