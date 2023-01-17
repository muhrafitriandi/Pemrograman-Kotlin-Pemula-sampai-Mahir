package null_safety

fun sayHello(friend: Friend?) {

    // Condition friend not null (if data null, data will not printed)
    // if (friend != null) {
    //     println("Hello ${friend.name}")
    // }

    // Safe call operator (null will be printed)
    // println("Hello ${friend?.name}")

    // Elvis Operator (if data null, will return default data i.e. Bro)
    // val result = friend?.name ?: "Bro"
    // println("Hello $result")

    // Double Bang Operator (percaya bahwa data tidak mungkin null, tetapi jika ternyata datanya null maka akan terjadi npe)
    println(friend!!.name)
}

fun main() {
    sayHello(Friend("Rafi"))
    sayHello(null)
}