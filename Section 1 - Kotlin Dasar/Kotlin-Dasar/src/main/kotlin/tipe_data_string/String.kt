package tipe_data_string

fun main() {
    val firstName = "Muhammad Rafi"
    val lastName = "Triandi"
    val address = """
        Menara Yarsi, Jl. Letjen Suprapto No.Kav. 13,
        RT.10/RW.5, Cemp. Putih Tim., Kec. Cemp. Putih, Kota Jakarta
        Pusat, Daerah Khusus Ibukota Jakarta 10510
    """.trimIndent()
    val multilineString = """
         *   Line 1
         *   Line 2
         *   Line 3
     """.trimMargin("*").trimIndent()

    val fullName = "$firstName $lastName"

    println("Firstname: $firstName")
    println("Lastname: $lastName")
    println("Address: $address")
    println("Fullname: $fullName")
    println("Length Fullname: ${fullName.length}")
    println(multilineString)
}