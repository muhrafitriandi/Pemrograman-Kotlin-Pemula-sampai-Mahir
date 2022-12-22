package break_dan_continue

fun main() {
    var i = 1
    // Case: Break
    while (true) {
        println("Break me! $i")
        i++
        if (i > 10) break
    }

    // Case: Continue
    for (j in 1..10) {
        if (j % 2 == 0) continue
        println(j)
    }
}

// Note:
// Case Break: Using while, because the number of iterations is unknown
// Case Continue: Using for, becase the number of iterations is known, 1..10