package destructuring_declaration

// Manual
//class Person(val name: String, val age: Int) {
//    operator fun component1() = name
//    operator fun component2() = age
//}

// Solve using data class, no need to create functionX()
data class Person(val name: String, val age: Int)

data class Result(val code: Int, val message: String)