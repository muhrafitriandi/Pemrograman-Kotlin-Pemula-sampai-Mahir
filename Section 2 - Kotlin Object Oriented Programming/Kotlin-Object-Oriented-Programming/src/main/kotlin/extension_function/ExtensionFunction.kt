package extension_function

fun main() {
    val student1 = Student("Muhammad", "Rafi", 1402019070)
    val student2: Student? = null
    val student3 = Student("Haviz", null, 1402019071)

    student1.greet()
    student2.greet()
    student3.greet()
}