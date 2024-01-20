package retrieve_by_position

fun main() {
    val numbers = setOf(10, 20, 30, 40, 50)

    // Mendapatkan elemen pada posisi tertentu
    val element = numbers.elementAt(2)
    println("Element at index 2: $element")

    // Mendapatkan elemen pertama
    val firstElement = numbers.first()
    println("First element: $firstElement")

    // Mendapatkan elemen terakhir
    val lastElement = numbers.last()
    println("Last element: $lastElement")

    // Mendapatkan elemen pada posisi tertentu atau null jika indeks di luar batas
    val elementNull = numbers.elementAtOrNull(10)
    println("Element at index 10 or null: $elementNull")

    // Mendapatkan elemen pada posisi tertentu atau nilai default jika indeks di luar batas
    val elementDefault = numbers.elementAtOrElse(10) { 0 }
    println("Element at index 10 or default value: $elementDefault")
}