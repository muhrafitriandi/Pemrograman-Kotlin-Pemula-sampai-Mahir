package lazy_properties

class MyClass {
    val myHeavyObject: HeavyObject by lazy {
        println("Creating myHeavyObject!")
        HeavyObject()
    }
}

class HeavyObject {
    // Some heavy and time-consuming initialization
}