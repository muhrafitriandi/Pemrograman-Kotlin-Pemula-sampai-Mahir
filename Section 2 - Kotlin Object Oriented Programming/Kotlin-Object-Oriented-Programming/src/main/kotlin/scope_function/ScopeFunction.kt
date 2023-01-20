package scope_function

fun main() {
    val student = Student("Rafi", 22)

    val studentLet = student.let {
        "Name: ${it.name}, Age: ${it.age}"
    }
    println(studentLet)

    val studentAlso = student.also {
        "Name: ${it.name}, Age: ${it.age}"
    }
    println(studentAlso)

    val studentRun = student.run {
         "Name: ${this.name}, Age: ${this.age}"
    }
    println(studentRun)

    val studentApply = student.apply {
        "Name: ${this.name}, Age: ${this.age}"
    }
    println(studentApply)
}