package tipe_data_number

fun main() {
    val age: Byte = 1
    val height: Short = 170
    // Default Data Type Integer Number is Int
    val distance = 2000
    val balance = 100000000L

    val value = 98.98F
    // Default Data Type Floating Point Number is Double
    val radius = 2342342343.54535

    val hexadecimalLiteral = 0xFF
    val binaryLiteral = 0b0011

    val price = 9_000_000_000L

    println("Value: $age, Data Type is ${age::class.simpleName}")
    println("Value: $height, Data Type is ${height::class.simpleName}")
    println("Value: $distance, Data Type is ${distance::class.simpleName}")
    println("Value: $balance, Data Type is ${balance::class.simpleName}")

    println()

    println("Value: $value, Data Type is ${value::class.simpleName}")
    println("Value: $radius, Data Type is ${radius::class.simpleName}")

    println()

    println("The value 0xFF from Hexadecimal to Decimal is $hexadecimalLiteral")
    println("The value 0b0001 from Binary to Decimal is $binaryLiteral")

    println()

    println("Final value casting from Long to Int is ${price.toInt()} which causes Number Overflow because Size (bits) Int is ${Int.SIZE_BITS}")
    println("Final value casting from Int (Binary to Decimal) to Double is ${binaryLiteral.toDouble()}")
}