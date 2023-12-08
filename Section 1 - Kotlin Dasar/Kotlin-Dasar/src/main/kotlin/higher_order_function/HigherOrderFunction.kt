package higher_order_function

// createAdder adalah sebuah higher-order function yang menerima sebuah integer sebagai parameter,
// dan mengembalikan sebuah function yang menerima sebuah integer dan mengembalikan sebuah integer.
fun createAdder(x: Int): (Int) -> Int {
    return { y -> x + y }
}

// flexible to calculate number
fun calculateNumber(x: Int, y: Int, calculate: (Int, Int) -> Int) = calculate(x, y)

fun sayHello(firstName: String, lastName: String, transform: (String, String) -> String): String {
    return transform(firstName, lastName)
}

fun main() {
    val addFive = createAdder(5)
    val result = addFive(3)
    println(result)

    println(sayHello("rafi", "triandy", { firstName: String, lastName: String ->
        "${firstName.uppercase()} ${lastName.uppercase()}"
    }))

    // Print with Trailing Lambda
    println(sayHello("joko", "kurnia") { firstName: String, lastName: String ->
        "${firstName.uppercase()} ${lastName.uppercase()}"
    })

    println(calculateNumber(10, 20) { x, y -> x.times(y) })

    // Lambda with Multiple Return Value
    val checkEvenOddNumber: (IntArray) -> Unit = {
        it.forEach { num ->
            val checkResult = when {
                num % 2 == 0 -> "$num is Even"
                else -> "$num is Odd"
            }
            println(checkResult)
        }
    }
    checkEvenOddNumber(intArrayOf(1, 2, 3))
}