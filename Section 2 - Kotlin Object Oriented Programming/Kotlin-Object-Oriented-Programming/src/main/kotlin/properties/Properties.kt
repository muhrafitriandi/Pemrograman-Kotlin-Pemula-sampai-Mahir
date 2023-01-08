package properties

fun main() {
    val zoro = Character()
    zoro.name = "Zoro"
    zoro.origin = "West Blue"
    zoro.epithet = "Pirate Hunter"
    zoro.bounty = 320_000_000

    val usopp = Character()
    usopp.name = "Usopp"
    usopp.origin = "East Blue"
    usopp.epithet = "Soge King"
    usopp.bounty = 200_000_000

    println(zoro.name)
    println(zoro.origin)
    println(zoro.epithet)
    println(zoro.bounty)
    println(zoro.health)

    println(usopp.name)
    println(usopp.origin)
    println(usopp.epithet)
    println(usopp.bounty)
    println(usopp.health)
}