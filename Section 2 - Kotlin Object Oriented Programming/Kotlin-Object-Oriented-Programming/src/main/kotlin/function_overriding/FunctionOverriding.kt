package function_overriding

fun main() {
    val manager = Manager("Ronaldo")
    val vicePresident = President("Jokowi")

    manager.sayHello("Messi")
    vicePresident.sayHello("Prabowo")
}