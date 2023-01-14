package sealed_class

import sealed_class.PaymentMethod.Paypal.name

sealed class PaymentMethod(val name: String) {
    class BankTransfer(name: String) : PaymentMethod(name)

    object Paypal : PaymentMethod(name)

    class EWallet(name: String) : PaymentMethod(name)
}