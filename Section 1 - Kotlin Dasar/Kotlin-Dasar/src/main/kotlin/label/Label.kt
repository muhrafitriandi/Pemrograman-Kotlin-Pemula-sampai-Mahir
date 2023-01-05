package label

fun labelBreak() {
    loopI@ for (i in 1..10) {
        loopJ@ for (j in 1..10) {
            if (i == 5) break@loopI
            println("$i x $j = ${i * j}")
        }
    }
}

fun labelContinue() {
    loopI@ for (i in 1..10) {
        loopJ@ for (j in 1..10) {
            if (j == 5) continue@loopI
            println("$i x $j = ${i * j}")
        }
    }
}

fun labelReturn() {
    sum((1..10).toList().toIntArray(), (1..10).toList().toIntArray()) sum@{ x, y ->
        loopI@ for (i in x.indices) {
            loopJ@ for (j in y.indices) {
                if (x[i] % 2 == 0) {
                    return@sum
                } else {
                    println("${x[i]} x ${y[j]} = ${x[i] * y[j]}")
                }
            }
        }
    }
}

fun sum(x: IntArray, y: IntArray, operation: (IntArray, IntArray) -> Unit) {
    operation(x, y)
}

fun main() {
    labelBreak()
    labelContinue()
    labelReturn()
}