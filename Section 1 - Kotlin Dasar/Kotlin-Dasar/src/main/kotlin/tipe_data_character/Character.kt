package tipe_data_character

fun main() {
    val r = 'R'
    val a = 'a'
    val f = 'f'
    val i = 'i'

    val rafi = "Rafi"

    println("The ASCII value of $r is: ${r.code}")
    println("The ASCII value of $a is: ${a.code}")
    println("The ASCII value of $f is: ${f.code}")
    println("The ASCII value of $i is: ${i.code}")

    println()

    println(rafi.map { ascii ->
        ascii.code
    })
}