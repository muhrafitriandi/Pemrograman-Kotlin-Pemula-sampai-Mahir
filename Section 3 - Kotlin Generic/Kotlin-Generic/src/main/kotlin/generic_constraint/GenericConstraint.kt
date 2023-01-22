package generic_constraint

fun main() {
    // with generic 1 parameter type. Jadi, harus mengimplementasikan Employee dan IWalk.
    // val data1 = Company(Employee("Rafi")) // error: not implemented IWalk
    // val data2 = Company(Manager("Jose Mourinho")) // error: not implemented IWalk

    // solve: with generic 2 parameter type. Dengan ini, tidak harus mengimplementasikan keduanya.
    val data1 = Company<Employee, IWalk>(Employee("Rafi"))
    val data2 = Company<Manager, IWalk>(Manager("Jose Mourinho"))

    val data3 = Company<VicePresident, IWalk>(VicePresident("Amin Maruf"))
    // val data4 = Company("This is a String") // error: type mismatch

    data1.employee.sayHello("Ronaldo")
    data2.employee.sayHello("Messi")
    data3.employee.sayHello("Mbappe")
    data3.employee.walk()
}