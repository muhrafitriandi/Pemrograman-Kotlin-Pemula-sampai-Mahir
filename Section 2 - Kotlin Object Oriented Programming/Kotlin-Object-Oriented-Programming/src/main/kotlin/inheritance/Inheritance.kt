package inheritance

fun main() {
    val manager = Manager("Ronaldo")
    val vicePresident = VicePresident("Jokowi")

    manager.sayHello("Messi")
    vicePresident.sayHello("Prabowo")
}