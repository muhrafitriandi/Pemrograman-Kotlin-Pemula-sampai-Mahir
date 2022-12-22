package tipe_data_range

fun main() {
    // val range = 1..100
    val range = 100 downTo 1 step 4

    println(range.count())
    println(range.contains(20))
    println(range.contains(101))
    println(range.first)
    println(range.last)
    println(range.step)
    println(range.filter { it % 2 == 0 })
    println(range.reversed())

}