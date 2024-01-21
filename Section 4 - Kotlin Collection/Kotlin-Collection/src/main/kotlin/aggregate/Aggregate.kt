package aggregate

import aggregate.data.Person

fun main() {
    val numbers = listOf(10, 5, 8, 15, 3)
    val people = listOf(
        Person("Alice", 25, 4_200_000),
        Person("Rock", 21, 3_000_000),
        Person("Martin", 22, 2_500_000),
        Person("Bob", 30, 5_500_000),
        Person("Vincent", 21, 2_500_000),
        Person("John", 35, 5_500_000),
        Person("Charlie", 22, 2_500_000),
        Person("David", 35, 5_500_000)
    )

    // Menggunakan max() untuk mendapatkan nilai maksimum
    val maxValue = numbers.max()
    println("Max value: $maxValue")

    // Menggunakan min() untuk mendapatkan nilai minimum
    val minValue = numbers.min()
    println("Min value: $minValue")

    // Menggunakan average() untuk mendapatkan nilai rata-rata
    val averageValue = numbers.average()
    println("Average value: $averageValue")

    // Menggunakan sum() untuk mendapatkan total nilai
    val sumValue = numbers.sum()
    println("Sum value: $sumValue")

    // Menggunakan count() untuk mendapatkan jumlah elemen
    val count = numbers.count()
    println("Count: $count")

    // Mengambil semua orang dengan umur tertua menggunakan Comparator (manual)
    val maxAgeManual = people.maxWith(compareBy { it.age }).age
    // Mengambil semua orang dengan umur tertua
    val maxAge = people.maxBy { it.age }.age
    val oldestPeople = people.filter { it.age == maxAge }
    println("Oldest people: $oldestPeople")

    // Mengambil semua orang dengan umur termuda menggunakan Comparator (manual)
    val minAgeManual = people.minWith(compareBy { it.age }).age
    // Mengambil semua orang dengan umur termuda
    val minAge = people.minBy { it.age }.age
    val youngestPerson = people.filter { it.age == minAge }
    println("Youngest person: $youngestPerson")

    // Menghitung pengeluaran gaji yang harus dibayarkan terhadap semua karyawan
    val sumSalary = people.sumOf { it.salary }
    println("The total that must be spent to pay employee salaries: $sumSalary")
}