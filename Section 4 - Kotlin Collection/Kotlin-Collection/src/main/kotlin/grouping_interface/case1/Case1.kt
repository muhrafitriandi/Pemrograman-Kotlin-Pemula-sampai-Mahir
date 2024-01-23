package grouping_interface.case1

fun main() {
    val numbers = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)

    val numbersGrouped: Grouping<Int, Int> = numbers.groupingBy { it }

    val countNumberBySameValue: Map<Int, Int> = numbersGrouped.eachCount()
    println(countNumberBySameValue)

    val reduceAndSum: Map<Int, Int> = numbersGrouped.reduce { _, first, second ->
        first + second
    }
    println(reduceAndSum)

    val sumValues1: Int = numbers.reduce { first, second ->
        first + second
    }
    val sumValues2: Int = reduceAndSum.values.sum()
    println("$sumValues2")

    val numberGroup = numbers.groupBy { it }
    val sumValues = numberGroup.mapValues {
        it.value.sum()
    }
    println(sumValues)
    val sumAll = sumValues.values.sum()
    println(sumAll)

}