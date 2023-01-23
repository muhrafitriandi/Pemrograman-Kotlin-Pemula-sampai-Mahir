package comparable_interface

fun main() {
    val fruit1 = Fruit("Apple", 20)
    val fruit2 = Fruit("Orange", 30)
    val fruit3 = Fruit("Strawberry", 30)

    println("${fruit1 < fruit2}, ${fruit1.compareTo(fruit2)}, ${fruit1 > fruit2}, ${fruit2.compareTo(fruit1)}")

    println("${fruit2 > fruit1}, ${fruit2.compareTo(fruit1)}, ${fruit2 < fruit1}, ${fruit1.compareTo(fruit2)}")

    println(fruit2 == fruit3) // false. because will not call the compareTo method but it's equals. compareTo method i.e. <. <=, >, >=

    println("${fruit2 <= fruit3}, ${fruit2.compareTo(fruit3)}, ${fruit3 >= fruit2}")
}
