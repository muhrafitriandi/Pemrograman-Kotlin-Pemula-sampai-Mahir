package any_class

fun main() {
    val samsung = Smartphone("Samsung S9+", 4_000_000, "Android", 2019)

    println(samsung.name)
    println(samsung.price)
    println(samsung.os)
    println(samsung.year)

    println(samsung.toString())
    println(samsung.hashCode())
}