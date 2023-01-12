package getter_dan_setter

fun main() {
    val note = Note("Belajar Kotlin OOP", "Materi OOP ini gampang banget")

    println(note.title)
    println(note.description)
    note.description = "" // not change/updated because set method has validation
    println(note.description)

}