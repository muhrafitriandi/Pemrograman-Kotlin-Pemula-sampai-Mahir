package late_initialized_properties

fun main() {
    val tv = Television()

    // println(tv.brand) // UninitializedPropertyAccessException

    tv.init("Xiaomi") // Option 1
    // tv.brand = "Xiaomi" // Option 2, without init function
    println(tv.brand)
}