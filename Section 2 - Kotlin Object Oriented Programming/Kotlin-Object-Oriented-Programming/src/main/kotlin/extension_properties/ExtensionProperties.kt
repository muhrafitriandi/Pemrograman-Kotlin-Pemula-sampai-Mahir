package extension_properties

import extension_function.Student

fun main() {
    val student1 = Student("Muhammad", "Rafi", 1402019070)
    val student2: Student? = null
    val student3 = Student("Haviz", null, 1402019071)

    println(student1.upperName)
    println(student2.upperName)
    println(student3.upperName)
}