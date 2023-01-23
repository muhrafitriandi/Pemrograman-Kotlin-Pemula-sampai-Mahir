package observableproperty_interface

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class LogObservableProperties<T>(val param: T) : ObservableProperty<T>(param) {
    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        println("Before change ${property.name} from $oldValue to $newValue")
        return true
    }

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("After change ${property.name} from $oldValue to $newValue")
    }
}

class Car(brand: String, year: Int) {
    var brand: String by LogObservableProperties(brand)
    var year: Int by LogObservableProperties(year)

    var owner: String by Delegates.notNull()
    var description: String by Delegates.vetoable("") { property, oldValue, newValue ->
        println("Before change ${property.name} from $oldValue to $newValue")
        true
    }
    var other: String by Delegates.observable("") { property, oldValue, newValue ->
        println("After change ${property.name} from $oldValue to $newValue")
    }
}

class CarManual(brand: String, year: Int) {

    private val logObservablePropertiesBrand = LogObservableProperties(brand)
    private val logObservablePropertiesYear = LogObservableProperties(year)

    private val logObservablePropertiesOwner = Delegates.notNull<String>()
    private val logObservablePropertiesDescription = Delegates.vetoable("") { property, oldValue, newValue ->
        println("Before change ${property.name} from $oldValue to $newValue")
        true
    }
    private val logObservablePropertiesOther = Delegates.observable("") { property, oldValue, newValue ->
        println("After change ${property.name} from $oldValue to $newValue")
    }

    var brand: String
        get() = logObservablePropertiesBrand.getValue(this, ::brand)
        set(value) {
            logObservablePropertiesBrand.setValue(this, ::brand, value)
        }

    var year: Int
        get() = logObservablePropertiesYear.getValue(this, ::brand)
        set(value) {
            logObservablePropertiesYear.setValue(this, ::brand, value)
        }

    var owner: String
        get() = logObservablePropertiesOwner.getValue(this, ::owner)
        set(value) {
            logObservablePropertiesOwner.setValue(this, ::owner, value)
        }

    var description: String
        get() = logObservablePropertiesDescription.getValue(this, ::description)
        set(value) {
            logObservablePropertiesDescription.setValue(this, ::description, value)
        }

    var other: String
        get() = logObservablePropertiesOther.getValue(this, ::other)
        set(value) {
            logObservablePropertiesOther.setValue(this, ::other, value)
        }
}