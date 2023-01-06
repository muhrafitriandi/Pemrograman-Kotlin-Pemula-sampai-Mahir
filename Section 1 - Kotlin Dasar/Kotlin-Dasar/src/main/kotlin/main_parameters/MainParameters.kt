package main_parameters

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Tidak ada argument yang diberikan")
    } else {
        println("Argument yang diberikan: ")
        for (i in args) {
            println(i)
        }
    }
}