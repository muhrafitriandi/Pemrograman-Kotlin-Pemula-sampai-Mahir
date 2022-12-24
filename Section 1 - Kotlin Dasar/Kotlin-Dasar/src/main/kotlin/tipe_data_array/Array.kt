package tipe_data_array

fun main() {
    val data = arrayOf("Rafi", 22, true)
    val gender = arrayOfNulls<String>(3)

    println(data[2])
    data[0] = "Brusli"
    println(data[0])

    println(gender[0])
    gender[0] = "Male"
    gender[1] = null
    gender[2] = "Female"
    // Error, Index out of bounds
    // gender[3] = "Dont Know"
    println(gender[0])
    println(gender.size)
}