package mapping

fun main() {
    val names = listOf("Rafi", "Nadhif", "Albet", "Muis", "Rosyid", "David", "Gilang", "Andhika", "Aldi", "Agung")

    val namesOdd = names.mapIndexedNotNull { index, value ->
        if (index % 2 == 0) null else value
    }
    println(namesOdd)
}