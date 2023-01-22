package generic_constraint

fun main() {
    val data1 = Company(Employee("Rafi"))
    val data2 = Company(Manager("Jose Mourinho"))
    val data3 = Company(VicePresident("Amin Maruf"))
    // val data4 = Company("This is a String") // error: type mismatch

    data1.employee.sayHello("Ronaldo")
    data2.employee.sayHello("Messi")
    data3.employee.sayHello("Mbappe")
}