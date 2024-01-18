package mapping

import mapping.data.Product

fun main() {
    val products = listOf(
        Product(1, "Laptop", 1200.0),
        Product(2, "Smartphone", 800.0),
        Product(3, "Headphones", 100.0)
    )

    // Manual
//    val mutableList = mutableListOf<Product>()
//    products.forEach { (id, name, price) ->
//        mutableList.add(Product(id = id, name = name, price = price * 2.0))
//    }
//    println(mutableList)

    val mapping = products.map { (id, name, price) ->
        Product(id = id, name = name, price = price * 2.0)
    }
    println(mapping)
}