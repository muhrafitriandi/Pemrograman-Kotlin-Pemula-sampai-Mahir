package type_projection

fun main() {
    val data1 = Container("Data 1")
    val data2: Container<Any> = Container("Data 2")

    copy(from = data1, to = data2)
    println(data1.data)
    println(data2.data)
}