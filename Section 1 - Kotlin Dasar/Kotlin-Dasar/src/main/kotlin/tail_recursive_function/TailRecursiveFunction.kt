package tail_recursive_function

tailrec fun factorialTailRecursive(n: Int, total: Int = 1): Int {
    return when (n) {
        1 -> total
        else -> factorialTailRecursive(n - 1, n * total)
    }
}

// iterasi 1: total=5*1=5, n=5-1=4
// iterasi 2: total=4*5=20, n=4-1=3
// iterasi 3: total=3*20=60, n=3-1=2
// iterasi 4: total=2*60=120, n=2-1=1
// iterasi 5: n=1, return total (120)

fun main() {
    println(factorialTailRecursive(5))
}