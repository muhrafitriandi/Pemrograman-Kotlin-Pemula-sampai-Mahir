package map

fun main() {
    val contactInfo = mapOf(
        "John" to "john@example.com",
        "Alice" to "alice@example.com",
        "Bob" to "bob@example.com"
    )

    // Menggunakan beberapa fungsi pada Map dan Pair
    println("Size of contactInfo: ${contactInfo.size}")
    println("Is contactInfo empty? ${contactInfo.isEmpty()}")
    println("Does contactInfo contain key 'Alice'? ${contactInfo.containsKey("Alice")}")
    println("Does contactInfo contain value 'bob@example.com'? ${contactInfo.containsValue("bob@example.com")}")

    // Mendapatkan nilai menggunakan key
    val johnsEmail = contactInfo["John"]
    println("Email of John: $johnsEmail")

    // Mendapatkan nilai dengan default jika key tidak ditemukan
    val marysEmail = contactInfo.getOrDefault("Mary", "Not available")
    println("Email of Mary: $marysEmail")

    // Mendapatkan kumpulan keys, values, dan entries
    val allNames = contactInfo.keys
    val allEmails = contactInfo.values
    val allEntries = contactInfo.entries
    println("All names: $allNames")
    println("All emails: $allEmails")
    println("All entries: $allEntries")

    // Menggunakan Pair untuk menyatukan key dan value
    val newContact: Pair<String, String> = "Eve" to "eve@example.com"
    // Menambahkan Pair ke dalam map
    val updatedContactInfo = contactInfo + newContact
    println("Updated contactInfo: $updatedContactInfo")

    for ((key, value) in contactInfo) {
        println("$key - $value")
    }
}