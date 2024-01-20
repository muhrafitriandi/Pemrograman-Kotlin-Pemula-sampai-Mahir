package checking_existence

fun main() {
    val fruits = listOf("Apple", "Banana", "Orange", "Mango", "Grapes")

    val checkApple = fruits.contains("Apple")
    println("Does the list contain Apple? $checkApple")

    val checkPineapple = fruits.contains("Pineapple")
    println("Does the list contain Pineapple? $checkPineapple")

    val searchFruits = listOf("Banana", "Mango", "Cherry")
    val checkAllFruits = fruits.containsAll(searchFruits)
    println("Does the list contain all searched fruits? $checkAllFruits")

    val isFruitsEmpty = fruits.isEmpty()
    println("Does the list is empty? $isFruitsEmpty")

    val isFruitsNotEmpty = fruits.isNotEmpty()
    println("Does the list is not empty? $isFruitsNotEmpty")
}