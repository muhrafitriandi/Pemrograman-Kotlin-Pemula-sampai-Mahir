package list_spesific_operations.case1

fun main() {
    val sortedArray = listOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    val targetValue = 23
    val result = binarySearchManual(sortedArray, targetValue)
    if (result != -1) {
        println("Nilai $targetValue ditemukan pada indeks $result.")
    } else {
        println("Nilai $targetValue tidak ditemukan dalam array.")
    }

    // Using Kotlin Ext Func
    val index = sortedArray.binarySearch(targetValue)
    println("Nilai $targetValue ditemukan pada indeks $index.")
}

fun binarySearchManual(arr: List<Int>, target: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = (low + high) / 2

        // Bandingkan nilai tengah dengan target
        when {
            arr[mid] == target -> return mid // Nilai ditemukan, kembalikan indeks
            arr[mid] < target -> low = mid + 1 // Nilai berada di sebelah kanan mid
            else -> high = mid - 1 // Nilai berada di sebelah kiri mid
        }
    }

    return -1 // Nilai tidak ditemukan
}
