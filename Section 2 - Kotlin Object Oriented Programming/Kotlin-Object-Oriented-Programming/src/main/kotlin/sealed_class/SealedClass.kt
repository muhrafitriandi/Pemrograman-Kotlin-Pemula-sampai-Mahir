package sealed_class

fun processPayment(paymentMethod: PaymentMethod) {
    return when (paymentMethod) {
        is PaymentMethod.BankTransfer -> println(paymentMethod.name)
        is PaymentMethod.Paypal -> println("Paypal")
        is PaymentMethod.EWallet -> println(paymentMethod.name)
    }
}

fun main() {
    val bankTransfer = PaymentMethod.BankTransfer("BCA")
    val person1 = Person("Rafi", bankTransfer)

    println(person1.name)
    processPayment(person1.paymentMethod)
}