package equals_function

fun main() {
    val company1 = Company("Grab", "Maspion Plaza, Lobby - Jl. Gunung Sahari No. 18, Jakarta, Indonesia.")
    val company2 = Company("Grab", "Maspion Plaza, Lobby - Jl. Gunung Sahari No. 18, Jakarta, Indonesia.")

    println(company1 == company2)
}