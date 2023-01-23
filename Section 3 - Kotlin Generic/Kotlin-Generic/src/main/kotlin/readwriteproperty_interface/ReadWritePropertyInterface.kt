package readwriteproperty_interface

fun main() {
    val person = Person("Rafi")
    println(person.name)
    person.name = "Triandy"
    println(person.name)
}