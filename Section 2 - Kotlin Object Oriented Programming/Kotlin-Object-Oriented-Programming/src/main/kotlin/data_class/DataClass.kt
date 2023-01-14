package data_class

fun main() {
    val personA = PersonA("Rafi") // data class
    val newPersonA = PersonA("Rafi")

    val personB = PersonB("Deni") // normal class
    val newPersonB = PersonB("Deni")

    val personC = PersonC("Fadil")
    val newPersonC = PersonC("Fadil")

    val person = Person("Triandi", "Male", Address("Bekasi", "O2 12A"))

    // Difference 1
    println(personA)
    println(personB)

    // Difference 2
    println(personA == newPersonA)
    println(personB == newPersonB)

    // Difference 3
    newPersonC.age = 34
    println(personC == newPersonC)
    println("$personC")
    println("$newPersonC")

    // Difference 4
    person.age = 34
    val copyOfPerson = person.copy(name = "Luffy")
    println(copyOfPerson)
    println(copyOfPerson.age) // not changed, because properties age not in primary constructor, so it's not special

    copyOfPerson.address.houseNo = "A13"
    println(person) // get changed, because properties houseNo is special

}