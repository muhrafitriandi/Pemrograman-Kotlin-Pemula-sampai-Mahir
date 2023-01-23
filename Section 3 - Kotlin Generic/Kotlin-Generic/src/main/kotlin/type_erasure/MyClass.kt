package type_erasure

class MyClass<T>(param: T) {
    private val data: T = param
    fun getData(): T = data
}