package visibility_modifier

fun main() {
    val electricCar = ElectricCar("Mobilio")

    println(electricCar.name) // case: public
    electricCar.drive() // case: protected
    electricCar.honk() // case: internal
    // electricCar.charge() // case: private
}

// public: dapat diakses dari mana saja, baik dari dalam maupun luar package.
// protected: hanya dapat diakses dari dalam class, dan juga turunannya.
// internal: hanya dapat diakses di module/project yang sama.
// private: hanya dapat diakses dari dalam class.