/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package mygradle

import com.google.gson.Gson
import core.CoreModule
import features.FeatureModule

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }

    fun operation(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
        return calculate(a, b)
    }
}

fun main() {
    println(App().greeting)

    val gson = Gson()

    val featureModule = FeatureModule()
    val coreModule = CoreModule()

    println(featureModule.featureFunction())
    println(coreModule.coreFunction())
}