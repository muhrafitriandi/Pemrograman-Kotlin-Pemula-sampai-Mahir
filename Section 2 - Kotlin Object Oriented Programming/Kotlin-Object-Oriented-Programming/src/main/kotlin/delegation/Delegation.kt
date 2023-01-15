package delegation

fun main() {
    val myBase = MyBase()
    val myBaseDelegationManual = MyBaseDelegationManual(myBase)
    val myBaseDelegation = MyBaseDelegation(myBase)

    // myBase.sayHello("Muhammad")

    myBaseDelegationManual.sayHello("Rafi")
    myBaseDelegationManual.sayGoodbye("Rafi")

    myBaseDelegation.sayHello("Triandi")
    myBaseDelegation.sayGoodbye("Triandi")
}