package generic_extension_function

class Data<T>(val data: T)

fun Data<String>.print() {
    val data: String = this.data
    println(data)
}