package coroutine.kotlin

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)

    val threadName = Thread.currentThread().name
    println("Running in thread $threadName")
}