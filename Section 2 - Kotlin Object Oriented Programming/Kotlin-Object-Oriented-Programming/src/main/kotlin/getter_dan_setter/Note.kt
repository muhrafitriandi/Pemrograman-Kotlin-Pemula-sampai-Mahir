package getter_dan_setter

class Note(private val _title: String, description: String) {
    var description = description
        get() {
            println("Getter Function Called")
            return field
        }
        set(value) {
            println("Setter Function Called")
            if (value.isNotBlank()) field = value
        }

    val title get() = this._title
}