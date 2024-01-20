package grouping.case1

import grouping.data.Employee

fun main() {
    val employee = listOf(
        Employee("Alice", 30, 50000.0, false),
        Employee("Bob", 35, 60000.0, true),
        Employee("Thomas", 40, 85000.0, false),
        Employee("Wilson", 45, 30000.0, true),
        Employee("Charlie", 50, 45000.0, false),
        Employee("David", 55, 55000.0, true)
    )

    // Mengelompokkan karyawan berdasarkan umur dengan range tertentu
    val agesGroup = employee.groupBy {
        when (it.age) {
            in 30..39 -> "30-39"
            in 40..49 -> "40-49"
            else -> "50-59"
        }
    }

    // Menghitung rata-rata gaji karyawan dengan range tertentu
    agesGroup.forEach { (ageGroup, employeeInGroup) ->
        val averageSalary = employeeInGroup.map { it.salary }.average()
        println("Average salary for employee in age group $ageGroup: $averageSalary")
    }

    // Menghitung rata-rata gaji karyawan tetap dan tidak tetap
    val (permanent, notPermanent) = employee.partition { it.isPermanent }
    println("Average salary for employee permanent: ${permanent.map { it.salary }.average()}")
    println("Average salary for employee not permanent: ${notPermanent.map { it.salary }.average()}")
}