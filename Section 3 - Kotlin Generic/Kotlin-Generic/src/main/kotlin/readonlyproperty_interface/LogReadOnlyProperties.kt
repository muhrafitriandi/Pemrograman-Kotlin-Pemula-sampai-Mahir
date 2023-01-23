package readonlyproperty_interface

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class NameWithLogManual(param: String) {
    private val logReadOnlyProperties = LogReadOnlyProperties(param)
    val name: String
        get() = logReadOnlyProperties.getValue(this, ::name)
}

class NameWithLog(param: String) {
    val name: String by LogReadOnlyProperties(param)
}

class LogReadOnlyProperties(val data: String) : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Access property ${property.name} with value $data")
        return data.uppercase()
    }

}