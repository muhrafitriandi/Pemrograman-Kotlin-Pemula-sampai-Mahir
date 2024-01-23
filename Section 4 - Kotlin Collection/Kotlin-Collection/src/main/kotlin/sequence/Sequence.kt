package sequence




//fun main() {
//    val words = "The quick brown fox jumps over the lazy dog".split(" ")
//
//    val resultList = words
//        .filter {
//            println("Filter: $it")
//            it.length > 3
//        }
//        .map {
//            println("Map: $it")
//            it.uppercase()
//        }
//        .take(4)
//    println(resultList)
//
//    println("=========================================================================================================")
//
//    val resultSequence = words.asSequence()
//        .filter {
//            println("Filter: $it")
//            it.length > 3
//        }
//        .map {
//            println("Map: $it")
//            it.uppercase()
//        }
//        .take(4)
//    println(resultSequence.toList())
//}