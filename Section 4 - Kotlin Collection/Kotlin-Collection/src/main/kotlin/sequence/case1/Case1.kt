package sequence.case1

import sequence.data.SensorReading

fun main() {
    // Generate data log sensor secara acak
    val sensorData = generateSensorData(1_000_000)

    // Memproses data sensor tanpa sequence
    val filteredReadingsList = sensorData
        .filter {
            println("Filter: ${it.value}")
            it.value > 0.5
        } // Memfilter nilai sensor yang lebih besar dari 0.5
        .map {
            println("Map: ${it.timestamp} - ${it.value}")
            it.timestamp to it.value
        } // Mengambil timestamp dan nilai sensor
        .take(4) // Mengambil 4 elemen pertama

    // Evaluasi dan cetak hasil
    println("Filtered Readings Using List: $filteredReadingsList")

    println("=========================================================================================================")

    // Memproses data sensor dengan sequence
    val filteredReadingsSequence = sensorData.asSequence()
        .filter {
            println("Filter: ${it.value}")
            it.value > 0.5
        } // Memfilter nilai sensor yang lebih besar dari 0.5
        .map {
            println("Map: ${it.timestamp} - ${it.value}")
            it.timestamp to it.value
        } // Mengambil timestamp dan nilai sensor
        .take(4) // Mengambil 4 elemen pertama

    // Evaluasi dan cetak hasil
    println("Filtered Readings Using Sequence: ${filteredReadingsSequence.toList()}")
}

// Fungsi untuk menghasilkan data sensor acak
fun generateSensorData(size: Int): List<SensorReading> {
    return List(size) {
        SensorReading(System.currentTimeMillis(), Math.random())
    }
}