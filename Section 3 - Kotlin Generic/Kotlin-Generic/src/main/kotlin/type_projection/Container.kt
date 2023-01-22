package type_projection

class Container<T>(var data: T)

fun copy(from: Container<out Any>, to: Container<in Any>) {
    to.data = from.data
}
