package coroutine.kotlin.membuat_coroutine.case1

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test

class Case1Test {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun testSensorMonitoring() {
        println("Aplikasi Pemantauan dimulai")

        GlobalScope.launch {
            // Tugas pemantauan suhu, kelembaban, tekanan, dll.
            while (true) {
                val temperature = readTemperatureSensor()
                val humidity = readHumiditySensor()
                val pressure = readPressureSensor()

                // Mencatat data pemantauan
                logMonitoringData(temperature, humidity, pressure)

                // Menunggu sebelum mencatat data selanjutnya
                delay(5000)
            }
        }

        runBlocking { delay(10_000) }

        println("Aplikasi Pemantauan selesai")
    }

    fun readTemperatureSensor(): Double {
        // Implementasi pembacaan suhu dari sensor
        return 25.5
    }

    fun readHumiditySensor(): Double {
        // Implementasi pembacaan kelembaban dari sensor
        return 60.0
    }

    fun readPressureSensor(): Double {
        // Implementasi pembacaan tekanan dari sensor
        return 1012.0
    }

    fun logMonitoringData(temperature: Double, humidity: Double, pressure: Double) {
        // Implementasi pencatatan data pemantauan
        println("Data Pemantauan - Suhu: $temperature, Kelembaban: $humidity, Tekanan: $pressure")
    }
}