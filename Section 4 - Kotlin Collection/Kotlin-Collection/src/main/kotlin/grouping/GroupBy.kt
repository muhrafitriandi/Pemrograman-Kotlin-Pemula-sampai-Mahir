package grouping

import grouping.data.Item

fun main() {
    val items = listOf(
        Item("Laptop", "Electronics", 1200.0),
        Item("Smartphone", "Electronics", 800.0),
        Item("Headphones", "Electronics", 100.0),
        Item("Book", "Literature", 20.0),
        Item("Camera", "Electronics", 500.0)
    )

    val groupingByCategory = items.groupBy { it.category }

    println("Items grouped by category:")
    groupingByCategory.forEach { (category, itemsInCategory) ->
        val itemNames = itemsInCategory.joinToString { it.name }
        println("$category: $itemNames")
    }
}