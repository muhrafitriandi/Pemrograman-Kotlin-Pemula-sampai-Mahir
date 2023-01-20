package annotation

@Fancy("Rafi")
class MyApplication(val name: String, val version: String) {
    fun info(): String = "Application: $name - $version"
}