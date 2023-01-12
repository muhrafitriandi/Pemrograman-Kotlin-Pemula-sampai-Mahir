package abstract_class

abstract class Location(vararg val name: String)

class City(vararg name: String) : Location(*name)

class Country(name: String) : Location(name)