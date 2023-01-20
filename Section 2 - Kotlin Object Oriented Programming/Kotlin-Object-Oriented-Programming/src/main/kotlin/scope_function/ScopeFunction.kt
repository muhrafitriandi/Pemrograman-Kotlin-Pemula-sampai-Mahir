package scope_function

fun main() {
    val student = Student("Rafi", 22)

    val studentLet = student.let {
        "Name: ${it.name}, Age: ${it.age}"
    }
    println(studentLet)
}