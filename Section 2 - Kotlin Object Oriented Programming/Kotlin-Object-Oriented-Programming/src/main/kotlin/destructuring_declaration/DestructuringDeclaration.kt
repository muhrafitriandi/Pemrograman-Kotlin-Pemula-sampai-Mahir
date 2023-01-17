package destructuring_declaration

fun main() {
    val person = Person("Rafi", 22)

    // With Class
    // val name = person.name
    // val age = person.age
    // println("My name is $name and I am $age years old")

    // With Data Class
    val (name, age) = person
    println("My name is $name and I am $age years old")
}