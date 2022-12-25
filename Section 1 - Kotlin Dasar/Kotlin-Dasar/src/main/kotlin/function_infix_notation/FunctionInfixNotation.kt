package function_infix_notation

infix fun String.isPalindrome(other: String): Boolean = this.lowercase().reversed() == other.lowercase()

fun main() {
    println("Kodok" isPalindrome "Kodok")
    println("Rafi" isPalindrome "Rafi")
    println("Rafi" isPalindrome "Ifar")
}