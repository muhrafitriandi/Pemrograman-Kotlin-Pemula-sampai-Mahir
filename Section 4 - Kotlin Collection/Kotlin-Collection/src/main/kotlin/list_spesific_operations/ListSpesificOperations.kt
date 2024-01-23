package list_spesific_operations

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val sortedNumbers = listOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    val fruits = listOf("Apple", "Orange", "Banana", "Apple")

    // Mendapatkan nilai pada indeks tertentu atau nilai default jika indeks tidak valid
    val nonExistingElement1 = numbers.getOrElse(10) { -1 }
    println("Element at index 10: $nonExistingElement1")

    // Mendapatkan nilai pada indeks tertentu atau null jika indeks tidak valid
    val nonExistingElement2 = numbers.getOrNull(10)
    println("Element at index 10: $nonExistingElement2")

    // Membuat sublist dari indeks 1 hingga 3 (inclusive)
    val sublist = numbers.subList(1, 4)
    println("Sublist: $sublist")

    // Mencari indeks nilai tertentu dalam list yang sudah terurut
    val index = sortedNumbers.binarySearch(23)
    println("Index of 5: $index")

    // Mencari indeks pertama kali nilai tertentu muncul dalam list
    val firstIndex = fruits.indexOf("Apple")
    println("First index of Apple: $firstIndex")

    // Mencari indeks terakhir kali nilai tertentu muncul dalam list
    val lastIndex = fruits.lastIndexOf("Apple")
    println("Last index of Apple: $lastIndex")

    // Mencari indeks pertama elemen yang memenuhi kondisi
    val firstEvenIndex = numbers.indexOfFirst { it % 2 == 0 }
    println("First index of even number: $firstEvenIndex")

    // Mencari indeks terakhir elemen yang memenuhi kondisi
    val lastEvenIndex = numbers.indexOfLast { it % 2 == 0 }
    println("Last index of even number: $lastEvenIndex")
}

