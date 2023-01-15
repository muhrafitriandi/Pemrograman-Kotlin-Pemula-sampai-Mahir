package singleton_object

class Application {
    object Version {
        fun version(name: String) {
            println("Version: $name")
        }
    }
}