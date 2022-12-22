package do_while_loop

fun main() {
    // var i = 0

    // note: Do-While Loop at least run 1 statement if condition is false. For example i = 100
    var i = 100
    do {
        println("Loop ${i+1}")
        i++
    } while (i < 5)
}