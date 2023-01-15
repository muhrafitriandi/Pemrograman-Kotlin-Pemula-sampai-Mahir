package singleton_object

fun main() {
    Database.addCustomer(Customer("Rafi"))
    println(Database.customers)
}