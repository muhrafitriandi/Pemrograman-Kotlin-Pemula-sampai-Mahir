package delegation

fun main() {
    val myBase = MyBase()
    val myBaseDelegation = MyBaseDelegationManual(myBase)

    // myBase.sayHello("Muhammad")
    myBaseDelegation.sayHello("Rafi")
    myBaseDelegation.sayGoodbye("Rafi")
}