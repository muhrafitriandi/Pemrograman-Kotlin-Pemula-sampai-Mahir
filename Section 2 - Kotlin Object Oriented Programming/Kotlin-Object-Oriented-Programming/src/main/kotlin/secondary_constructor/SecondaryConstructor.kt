package secondary_constructor

fun main() {
    val rafi = Person("Rafi")
    println(rafi.name)
    println(rafi.age)
    println(rafi.address)

    val madun = Person("Madun", 22)
    println(madun.name)
    println(madun.age)
    println(madun.address)

    val rizal = Person("Rizal", 24, "Jl. Kenanga No.12A")
    println(rizal.name)
    println(rizal.age)
    println(rizal.address)
}