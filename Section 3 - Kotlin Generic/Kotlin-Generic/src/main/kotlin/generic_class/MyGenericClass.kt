package generic_class

class MyGenericClass<T>(val value: T) {
    fun getData(): T = this.value

    fun printData() = println("The value is ${this.value}")
}