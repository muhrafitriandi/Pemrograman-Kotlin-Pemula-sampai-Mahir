package anonymous_class

fun attack(attack: IAttack) {
    attack.cubit()
}

fun main() {
    // Cara umum
    val balmond = Balmond()
    attack(balmond)

    // Gunakan anonymous class jika objek tidak memiliki properties, daripada harus membuat object dan class yang mengimplementasikannya secara berulang-ulang
    attack(object : IAttack {
        override fun cubit() {
            println("Balmond Nyubit menggunakan jepitan jemuran")
        }
    })

    attack(object : IAttack {
        override fun cubit() {
            println("Layla Nyubit menggunakan gunting")
        }
    })
}