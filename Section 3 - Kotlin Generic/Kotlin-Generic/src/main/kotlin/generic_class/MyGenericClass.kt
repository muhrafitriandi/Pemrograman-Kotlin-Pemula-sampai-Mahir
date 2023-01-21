package generic_class

class MyGenericClass<T>(val value: T) {
    fun getData(): T = this.value

    fun printData() = println("The value is ${this.value}")
}

class Pair<T, U>(val first: T, val second: U) {
    fun getFirstData(): T = first

    fun getSecondData(): U = second

    fun printData() = println("First data is ${this.first}. Second data is ${this.second}")
}