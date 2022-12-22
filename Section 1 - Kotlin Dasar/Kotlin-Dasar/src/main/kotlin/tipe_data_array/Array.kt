package tipe_data_array

fun main() {
    val names: Array<String> = arrayOf("Rafi", "Madun", "Rijal")
    val gender: Array<String?> = arrayOfNulls(3)

    println(names[0])
    names[0] = "Brusli"
    println(names[0])

    println(gender[0])
    gender[0] = "Male"
    gender[1] = null
    gender[2] = "Female"
    // Error, Index out of bounds
    // gender[3] = "Dont Know"
    println(gender[0])
    println(gender.size)
}