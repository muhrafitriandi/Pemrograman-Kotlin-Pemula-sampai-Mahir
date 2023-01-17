package destructuring_declaration

fun getResult(value1: Int, value2: String): Result {
    return Result(value1, value2)
}

fun getTotalPrice(item: List<Purchase>, callback: PurchaseCallback): Double {
    return callback(item)
}

fun main() {
    val person = Person("Rafi", 22)

    // With Class
    // val name = person.name
    // val age = person.age
    // println("My name is $name and I am $age years old")

    // With Data Class
    val (name, age) = person
    println("My name is $name and I am $age years old")

    // -----------------------------------------------------------------------------------------------------------------

    // Destructuring Function
    // Manual
    val result = getResult(401, "Unauthorized")
    // val status = result.status
    // val message = result.message
    // println("Status: $status, Message: $message")

    // Simplify
    val (status, message) = result
    println("Status: $status, Message: $message")

    // -----------------------------------------------------------------------------------------------------------------

    // Ignoring other unnecessary variables
    val (status2, _) = result
    println("Status: $status2")

    // -----------------------------------------------------------------------------------------------------------------

    // Destructurin Lambda Parameter
    // Manual
    val purchases = listOf(Purchase("Apple", 0.5), Purchase("Banana", 0.25))
    // val total = getTotalPrice(purchases) { count ->
    //     count.sumOf { purchase ->
    //         purchase.price
    //     }
    // }

    // Simplify
    val total = getTotalPrice(purchases) { count ->
        count.sumOf { (_, price) ->
            price
        }
    }
    println("Total price of all purchases: $total")
}