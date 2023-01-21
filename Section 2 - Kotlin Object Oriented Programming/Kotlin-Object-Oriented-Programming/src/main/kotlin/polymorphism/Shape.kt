package polymorphism

interface Shape {
    fun draw()
}

class Rectangle : Shape {
    override fun draw() {
        println("Menggambar persegi panjang")
    }

}

class Circle : Shape {
    override fun draw() {
        println("Menggambar lingkaran")
    }

}