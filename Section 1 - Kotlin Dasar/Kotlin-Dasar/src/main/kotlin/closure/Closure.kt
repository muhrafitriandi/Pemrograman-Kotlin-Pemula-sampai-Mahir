package closure

fun main() {
    var counter = 0

    val lambdaIncrement = {
        counter++
    }

    val anonymousIncrement = fun () {
        counter++
    }

    fun functionIncrement() {
        counter++
    }

    lambdaIncrement()
    anonymousIncrement()
    functionIncrement()
    println(counter)
}