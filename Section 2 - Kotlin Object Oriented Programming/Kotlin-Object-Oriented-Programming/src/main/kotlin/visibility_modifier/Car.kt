package visibility_modifier

open class Car(val name: String) {
    protected open fun drive() {
        println("${this.name} is Driving")
    }

    internal fun honk() {
        println("Honk Honk!")
    }
}

class ElectricCar(name: String): Car(name){
    public override fun drive() {
        super.drive()
        println("This is Electric Car")
    }
    private fun charge() {
        println("${this.name} is Charging")
    }
}