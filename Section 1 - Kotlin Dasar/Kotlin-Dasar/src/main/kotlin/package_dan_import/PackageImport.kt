package package_dan_import

import package_dan_import.util.calculateAge

fun main() {
    print("Enter your name: ")
    val name = readln()

    print("Enter your date of birth (dd mm yyyy): ")
    val (day, month, year) = readln().split(" ").map {
        it.toInt()
    }

    println("My Name is $name and My Age is ${calculateAge(day, month, year)}")
}

