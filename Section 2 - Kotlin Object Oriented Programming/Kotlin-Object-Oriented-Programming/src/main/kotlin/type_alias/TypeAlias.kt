package type_alias

import type_alias.test1.Application

typealias App1 = Application
typealias App2 = type_alias.test2.Application

typealias Count = (Int, Int) -> Int

fun sum(x: Int, y: Int, count: Count) {
    println("$x + $y = ${count(x, y)}")
}

fun subtraction(x: Int, y: Int, count: Count) {
    println("$x - $y = ${count(x, y)}")
}

fun main() {
    val app1 = App1
    val app2 = App2

    app1.version("1.2")
    app2.version("1.3")

    sum(10, 5, Int::plus)
    subtraction(10, 5, Int::minus)
}