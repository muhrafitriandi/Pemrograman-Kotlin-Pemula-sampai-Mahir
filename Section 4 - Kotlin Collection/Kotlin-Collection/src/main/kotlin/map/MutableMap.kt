package map

fun main() {
    val contactInfo = mutableMapOf(
        "John" to "john@example.com",
        "Alice" to "alice@example.com",
        "Bob" to "bob@example.com"
    )

    // Menambahkan elemen baru ke dalam map menggunakan put
    contactInfo["Eve"] = "eve@example.com"
    println("After adding Eve: $contactInfo")

    // Menghapus elemen dari map menggunakan remove(K)
    contactInfo.remove("Bob")
    println("After removing Bob: $contactInfo")

    // Menghapus elemen dari map menggunakan remove(K, V)
    contactInfo.remove("Alice", "alice@example.com")
    println("After removing Alice with email alice@example.com: $contactInfo")

    // Menyisipkan semua elemen dari map lain menggunakan putAll
    val additionalUsers = mapOf(
        "Charlie" to "charlie@example.com",
        "David" to "david@example.com"
    )
    contactInfo.putAll(additionalUsers)
    println("After adding additional users: $contactInfo")

    // Membersihkan semua elemen dari map menggunakan clear
    contactInfo.clear()
    println("After clearing the map: $contactInfo")

    // Membuat mutableMap baru dan menambahkan elemen menggunakan put
    val fruitMap = mutableMapOf(
        "Apple" to 5,
        "Banana" to 3,
        "Orange" to 8
    )

    // Mengakses kumpulan keys, values, dan entries
    val allFruits = fruitMap.keys
    val fruitQuantities = fruitMap.values
    val fruitEntries = fruitMap.entries
    println("All fruits: $allFruits")
    println("Fruit quantities: $fruitQuantities")
    println("Fruit entries: $fruitEntries")

    // Mengubah nilai untuk kunci tertentu menggunakan setValue
    fruitMap["Banana"] = 10
    println("After updating Banana quantity: $fruitMap")

    for ((key, value) in contactInfo) {
        println("$key - $value")
    }
}