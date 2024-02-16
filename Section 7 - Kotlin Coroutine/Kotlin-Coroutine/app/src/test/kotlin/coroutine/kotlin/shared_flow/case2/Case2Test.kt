package coroutine.kotlin.shared_flow.case2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

data class Item(val name: String, val price: Double)

class Case2Test {
    @Test
    fun testItem() {
        runBlocking {
            // SharedFlow to hold the cart items
            val cartItems = MutableSharedFlow<List<Item>>()
            // Launch a coroutine to print the cart on SharedFlow
            launch {
                cartItems.collect { items ->
                    println("Cart Updated: $items")
                }
            }
            // Launch another coroutine to trigger order confirmation when the cart is full
            launch {
                cartItems.filter { it.size >= 3 } // Filter for 3 or more items
                    .onEach { println("Order Confirmation triggered!") }
                    .launchIn(this)
            }
            // Launch a coroutine to simulate adding items to the cart
            launch {
                var updatedItems = listOf(Item("Apple", 1.50))
                cartItems.emit(updatedItems)
                delay(1000)
                updatedItems = updatedItems + Item("Milk", 2.00)
                cartItems.emit(updatedItems)
                delay(1000)
                updatedItems = updatedItems + Item("Bread", 3.00)
                cartItems.emit(updatedItems)
            }
            delay(Long.MAX_VALUE)
        }
    }
}