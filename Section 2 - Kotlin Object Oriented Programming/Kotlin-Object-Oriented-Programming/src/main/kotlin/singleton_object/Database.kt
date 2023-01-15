package singleton_object

object Database {
    val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }
}