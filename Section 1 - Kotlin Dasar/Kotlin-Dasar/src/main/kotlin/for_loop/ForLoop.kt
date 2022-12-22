package for_loop

fun main() {
    val names = arrayOf("Muhammad", "Rafi", "Triandi")
    var iteration = 0

    // For Array
    // Way 1
    // for (name in names) {
    //     println(name)
    //     iteration++
    // }
    // println("Total Iterations: $iteration")

    // Way 2
    names.forEach { name ->
        println(name)
        iteration++
    }
    println("Total Iterations: $iteration")


    // For Range
    // Way 1
    // print("Odd Number 1-100: ")
    // for (number in 1..100 step 2) {
    //     print("$number, ")
    // }
    // println()
    // print("Even Number 1-100: ")
    // for (number in (100 downTo 1 step 2).reversed()) {
    //     print("$number, ")
    // }

    // Way 2
    print("Odd Number 1-100: ")
    (1..100 step 2).forEach { number ->
        print("$number, ")
    }
    println()
    print("Even Number 1-100: ")
    (100 downTo 1 step 2).reversed().forEach { number ->
        print("$number, ")
    }


    println()
    // For with Index
    // Way 1
    // for (index in names.indices) {
    //     println("Index ke-$index = ${names[index]}")
    // }

    // Way 2
    // for ((index, value) in names.withIndex()) {
    //     println("Index ke-$index = $value")
    // }

    // Way 3
    (names).forEachIndexed { index, value ->
        println("Index ke-$index = $value")
    }
}

// Note: names.indices same meaning as 0..names.size-1