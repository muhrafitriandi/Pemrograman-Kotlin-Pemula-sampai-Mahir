package hashcode_function

import equals_function.Company

fun main() {
    val company1 = Company("Grab", "Maspion Plaza, Lobby - Jl. Gunung Sahari No. 18, Jakarta, Indonesia.")
    val company2 = Company("Grab", "Maspion Plaza, Lobby - Jl. Gunung Sahari No. 18, Jakarta, Indonesia.")

    println(company1.hashCode())
    println(company2.hashCode())
    println(company1.hashCode() == company2.hashCode())
}