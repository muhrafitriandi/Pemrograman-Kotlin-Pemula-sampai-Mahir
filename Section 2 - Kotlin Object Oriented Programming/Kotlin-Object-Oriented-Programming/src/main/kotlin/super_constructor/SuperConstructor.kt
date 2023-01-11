package super_constructor

fun main() {
    val premiumCustomer = PremiumCustomer("Rafi")
    println(premiumCustomer.name)
    println(premiumCustomer.type)
    println(premiumCustomer.balance)

    val executiveCustomer1 = ExecutiveCustomer("Triandy", 1_000_000)
    println(executiveCustomer1.name)
    println(executiveCustomer1.type)
    println(executiveCustomer1.balance)

    val executiveCustomer2 = ExecutiveCustomer("Mamat")
    println(executiveCustomer2.name)
    println(executiveCustomer2.type)
    println(executiveCustomer2.balance)
}