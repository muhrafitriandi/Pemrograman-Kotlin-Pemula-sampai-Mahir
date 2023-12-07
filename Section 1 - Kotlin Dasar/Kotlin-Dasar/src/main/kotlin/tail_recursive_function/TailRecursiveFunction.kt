package tail_recursive_function

tailrec fun factorialTailRecursive(n: Int, total: Int = 1): Int {
    return when (n) {
        1 -> total
        else -> factorialTailRecursive(n - 1, n * total)
    }
}

// iterasi 1: total=5*1=5, n=5-1=4 (5, 1)
// iterasi 2: total=4*5=20, n=4-1=3 (4, 5)
// iterasi 3: total=3*20=60, n=3-1=2 (3, 20)
// iterasi 4: total=2*60=120, n=2-1=1 (2, 60)
// iterasi 5: total=1*120=120, n=1 -> return total (120) (1, 120)


// Independent Challenge
tailrec fun fibonacci(n: Int, fn1: Int = 0, fn2: Int = 1): Int {
    return when (n) {
        0 -> fn1
        1 -> fn2
        else -> fibonacci(n - 1, fn2, fn1 + fn2)
    }
}

// iterasi 1: n=5, fn1=0, fn2=1 (5, 0, 1)
// iterasi 2: n=4, fn1=1, fn2=0+1=1 (4, 1, 1)
// iterasi 3: n=3, fn1=1, fn2=1+1=2 (3, 1, 2)
// iterasi 4: n=2, fn1=2, fn2=1+2=3 (2, 2, 3)
// iterasi 5: n=1, fn1=3, fn2=2+3=5 -> return fn2 (5) (1, 3, 5)

fun main() {
    println(factorialTailRecursive(5))
    println(fibonacci(5))
}