package map_spesific_operations

fun main() {
    val scores = mapOf("Alice" to 85, "Bob" to 90, "Charlie" to 75)

    // Mendapatkan nilai untuk kunci tertentu atau nilai default jika kunci tidak ada
    val davidScore = scores.getOrElse("David") { -1 }
    println("David's Score: $davidScore")

    // Mendapatkan nilai untuk kunci tertentu atau lempar exception jika kunci tidak ada
    // val bobScore = scores.getValue("David") // Exception Key is missing
    val bobScore = scores["David"] // null, Key is not found
    println("Bob's Score: $bobScore")

    // Menciptakan map baru dengan elemen yang memenuhi kondisi tertentu
    val passingScores = scores.filter { (_, score) -> score >= 80 }
    println("Passing Scores: $passingScores")

    // Menciptakan map baru dengan kunci yang memenuhi kondisi tertentu
    val namesStartingWithA = scores.filterKeys { it.startsWith("A") }
    println("Names Starting with A: $namesStartingWithA")

    // Menciptakan map baru dengan nilai yang memenuhi kondisi tertentu
    val highScores = scores.filterValues { it >= 80 }
    println("High Scores: $highScores")
}