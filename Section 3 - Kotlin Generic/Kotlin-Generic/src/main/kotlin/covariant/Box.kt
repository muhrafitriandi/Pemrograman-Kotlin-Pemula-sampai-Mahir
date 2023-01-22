package covariant

class Box<out T>(val item: T) {
    fun getData(): T = item
}