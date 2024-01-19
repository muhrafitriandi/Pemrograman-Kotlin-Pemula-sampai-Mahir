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

    val groupingByCategory = items.groupingBy { it.category }

    println("Items grouped by category:")
    groupingByCategory.eachCount().forEach { (category, count) ->
        println("$category: $count items")
    }
}