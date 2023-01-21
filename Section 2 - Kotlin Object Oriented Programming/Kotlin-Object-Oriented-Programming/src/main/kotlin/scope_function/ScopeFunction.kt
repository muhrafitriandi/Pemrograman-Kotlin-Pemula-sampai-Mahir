package scope_function

fun main() {
    val student = Student("Rafi", 22)

    val studentLet = student.let {
        "Name: ${it.name}, Age: ${it.age}"
    }
    println(studentLet)

    val studentRun = student.run {
         "Name: ${this.name}, Age: ${this.age}"
    }
    println(studentRun)

    val studentApply = student.apply { // apply will return object Student
        "Name: ${this.name}, Age: ${this.age}" // Ignore, because the return value is Unit
    }
    println(studentApply)

    val studentAlso = student.also { // also will return object Student
        "Name: ${it.name}, Age: ${it.age}" // Ignore, because the return value is Unit
    }
    println(studentAlso)

    // Like run function
    val studentWith = with(student) {
        "Name: ${this.name}, Age: ${this.age}"
    }
    println(studentWith)
}