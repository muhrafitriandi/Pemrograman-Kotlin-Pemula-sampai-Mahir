package readwriteproperty_interface

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LogReadWriteOnlyProperties(var data: String): ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Get property ${property.name} with value $data")
        return data
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("Set property ${property.name} from $data to $value")
        data = value
    }
}

class PersonManual(param: String) {

    private val logReadWriteOnlyProperties = LogReadWriteOnlyProperties(param)
    var name: String
        get() = logReadWriteOnlyProperties.getValue(this, ::name)
        set(value) {
            // logReadWriteOnlyProperties.data = value // line 13 will not called
            logReadWriteOnlyProperties.setValue(this, ::name, value) // line 13 will called every data has changed.
        }
}

class Person(param: String) {
    var name: String by LogReadWriteOnlyProperties(param)
}