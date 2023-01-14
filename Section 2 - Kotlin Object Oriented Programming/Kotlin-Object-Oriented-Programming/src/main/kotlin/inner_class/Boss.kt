package inner_class

class Boss(val name: String) {

    private fun answer() {
        println("Your salary will be paid on January 1st")
    }

    inner class Employee(val name: String) {
        fun ask() {
            println("Excuse me, Boss ${this@Boss.name}. Im $name want to ask, when will my salary be paid?")
            // ${this@Boss.name} :: error if dont using inner, to solve this -> using inner keyword to access properties/function in outer class.
        }

        fun answer() {
            this@Boss.answer()
        }
    }
}