package iterator

fun <T> displayMutableListIterator(listIterator: MutableListIterator<T>, action: (MutableListIterator<T>) -> Unit) {
    action(listIterator)
}

fun printOddNumber(listIterator: MutableListIterator<Int>) {
    while (listIterator.hasNext()) {
        val item = listIterator.next()
        if (item % 2 == 0) listIterator.remove()
        else println(item)
    }
}

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    displayMutableListIterator(list.listIterator()) {
        printOddNumber(list.listIterator())
    }
}