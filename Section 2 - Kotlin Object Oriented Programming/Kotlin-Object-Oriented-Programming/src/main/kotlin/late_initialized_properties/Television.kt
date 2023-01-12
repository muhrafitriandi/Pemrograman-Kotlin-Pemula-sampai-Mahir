package late_initialized_properties

class Television {
    lateinit var brand: String

    fun init(brand: String) {
        this.brand = brand
    }
}