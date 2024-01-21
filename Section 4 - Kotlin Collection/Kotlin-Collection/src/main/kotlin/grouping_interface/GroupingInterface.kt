package grouping_interface

import grouping_interface.data.Product

fun main() {
    val products = listOf(
        Product("1", "Electronics", 500.0),
        Product("2", "Clothing", 30.0),
        Product("3", "Electronics", 800.0),
        Product("4", "Clothing", 25.0),
        Product("5", "Electronics", 1200.0),
        Product("6", "Books", 20.0),
        Product("7", "Books", 15.0)
    )

    // Mengelompokkan produk berdasarkan kategori menggunakan Grouping
    val groupedByCategory = products.groupingBy { it.category }

    // Menggunakan eachCount() untuk menghitung jumlah produk dalam setiap kategori
    val productCountByCategory = groupedByCategory.eachCount()
    println("Jumlah produk per kategori: $productCountByCategory")

    // Menggunakan reduce() untuk menghitung total harga produk dalam setiap kategori
    val totalPricesByCategory = groupedByCategory.reduce { key, first, second ->
        first.copy(price = first.price + second.price)
    }
    println("Total harga produk per kategori (reduce): $totalPricesByCategory")

    // Menggunakan fold() untuk menghitung total harga produk dalam setiap kategori
    val totalPricesByCategoryFold = groupedByCategory.fold(0.0) { first, second ->
        first + second.price
    }
    println("Total harga produk per kategori (fold): $totalPricesByCategoryFold")

    // Menggunakan aggregate() untuk menghitung total harga produk dalam setiap kategori
    val totalPricesByCategoryAggregate = groupedByCategory.aggregate { key, first: Product?, second, isFirst ->
        if (isFirst) {
            // Jika ini adalah elemen pertama dalam kelompok, gunakan element sebagai akumulator awal
            second
        } else {
            // Jika bukan elemen pertama, akumulasi nilai harga
            first?.copy(price = first.price + second.price) ?: second
        }
    }
    println("Total harga produk per kategori (aggregate): $totalPricesByCategoryAggregate")
}