package any_class

class Laptop(val name: String)

class Computer(val name: String)

open class Detail(val price: Int, val os: String, val year: Int)

class Smartphone(val name: String, price: Int, os: String, year: Int) : Detail(price, os, year)