package association

import mapping.data.Product

fun main() {
    val products = listOf(
        Product(1, "Laptop", 1200.0),
        Product(2, "Smartphone", 800.0),
        Product(3, "Headphones", 100.0)
    )

    val associateManual: Map<Product, Double> = products.associate { Pair(it, it.price) }

    val productToPriceMap: Map<Product, Double> = products.associateWith { it.price }
    println(productToPriceMap)
}