package iterator

fun <T> displayListIterator(listIterator: ListIterator<T>) {
    // Iterasi ke depan menggunakan next
    while (listIterator.hasNext()) {
        val element = listIterator.next()
        println("Iterasi ke depan: $element")

        // Mendapatkan index setelah iterasi ke depan
        val nextIndex = listIterator.nextIndex()
        println("Index setelah iterasi ke depan: $nextIndex")
    }

    // Iterasi ke belakang menggunakan previous
    while (listIterator.hasPrevious()) {
        val element = listIterator.previous()
        println("Iterasi ke belakang: $element")

        // Mendapatkan index setelah iterasi ke belakang
        val previousIndex = listIterator.previousIndex()
        println("Index setelah iterasi ke belakang: $previousIndex")
    }
}

fun main() {
    // Membuat list sebagai contoh
    val myList = listOf("A", "B", "C", "D", "E")

    // Mendapatkan ListIterator dari myList
    val listIterator = myList.listIterator()

    displayListIterator(listIterator)
}
