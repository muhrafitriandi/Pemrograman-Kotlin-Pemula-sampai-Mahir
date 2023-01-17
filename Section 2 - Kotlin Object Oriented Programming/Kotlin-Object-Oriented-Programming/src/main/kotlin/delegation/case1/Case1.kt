package delegation.case1

fun main() {
    val developerAndroid = DeveloperAndroid()
    val developerIOS = DeveloperIOS()
    val client = Client(developerAndroid)

    client.detection("Luka Bakar")
    client.browser("Chrome")
}