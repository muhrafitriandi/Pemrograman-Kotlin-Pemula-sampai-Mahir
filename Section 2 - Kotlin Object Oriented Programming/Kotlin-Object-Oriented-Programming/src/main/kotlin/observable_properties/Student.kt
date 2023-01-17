package observable_properties

import kotlin.properties.Delegates

class Student(name: String, quizScore: Int) {
    var name: String by Delegates.observable(name) { property, oldValue, newValue ->
        println("${property.name} is changed from $oldValue to $newValue")
    }

    var quiz: Int by Delegates.vetoable(quizScore) { property, oldValue, newValue ->
        if (newValue <= 60) {
            println("Your Quiz Score: $oldValue")
            false
        } else {
            println("${property.name} is changed from $oldValue to $newValue")
            true
        }
    }
}

// Note: Analogi, misalnya (Remedial Nilai Ujian).
// observable() akan selalu mengupdate nilai ujian, mau nilai remedialnya diatas ataupun dibawah rata" (mendeteksi setiap perubahan).
// vetoable() hanya akan mengupdate nilai ujian, ketika nilai remedialnya valid, misal: diatas rata" (hanya mendeteksi perubahan ketika nilainya valid).