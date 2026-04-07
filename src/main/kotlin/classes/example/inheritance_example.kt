package classes.example

open class Parent (open val prop: String) {
    val value = prop.toUpperCase() // Здесь prop == null, т.к. он переопределен в classes.example.Child
                                    // и реально создается только после выполнения конструктора classes.example.Parent

    init {
        println(value)
    }
}

class Child : Parent ("") {
    override val prop = "child";
}

fun main() {
    val obj = Child()
}