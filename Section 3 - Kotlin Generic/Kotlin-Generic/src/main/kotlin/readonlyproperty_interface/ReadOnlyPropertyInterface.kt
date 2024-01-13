package readonlyproperty_interface

fun main() {
    val university = University()

    // Menambahkan beberapa mahasiswa ke universitas
    university.addStudent(Student("John", 20))
    university.addStudent(Student("Jane", 22))
    university.addStudent(Student("Bob", 21))

    // Mengakses properti read-only untuk mendapatkan jumlah mahasiswa
    println("Jumlah Mahasiswa: ${university.numberOfStudents}")

    // --------

    val nameWithLog = NameWithLog("Rafi")
    println(nameWithLog.name)
    println(nameWithLog.name)
}