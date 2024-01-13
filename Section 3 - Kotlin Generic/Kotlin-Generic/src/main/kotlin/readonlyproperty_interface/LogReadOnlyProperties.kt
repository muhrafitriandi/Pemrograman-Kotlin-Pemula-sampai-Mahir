package readonlyproperty_interface

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

data class Student(val name: String, val age: Int)

class University {
    private val studentList = mutableListOf<Student>()

    val numberOfStudents by StudentsCountDelegate()

    fun addStudent(student: Student) {
        studentList.add(student)
    }

    private class StudentsCountDelegate : ReadOnlyProperty<University, Int> {
        override fun getValue(thisRef: University, property: KProperty<*>): Int {
            return thisRef.studentList.size
        }
    }
}

class UniversityManual {
    private val studentList = mutableListOf<Student>()

    val numberOfStudents: Int
        get() = StudentsCountDelegate().getValue(this, ::numberOfStudents)

    fun addStudent(student: Student) {
        studentList.add(student)
    }

    private class StudentsCountDelegate : ReadOnlyProperty<UniversityManual, Int> {
        override fun getValue(thisRef: UniversityManual, property: KProperty<*>): Int {
            return thisRef.studentList.size
        }
    }
}

// ------------------

class NameWithLogManual(param: String) {
    private val logReadOnlyProperties = LogReadOnlyProperties(param)
    val name: String
        get() = logReadOnlyProperties.getValue(this, ::name)
}

class NameWithLog(param: String) {
    val name: String by LogReadOnlyProperties(param)
}

class LogReadOnlyProperties(val data: String) : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Access property ${property.name} with value $data")
        return data.uppercase()
    }

}