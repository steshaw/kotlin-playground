class User(firstName: String, var lastName: String, var age: Int) {
    private var _firstName: String
    var firstName: String
        get() = this._firstName
        set(value) {
            this._firstName = value
        }

    init {
        // Do some crazy logic
        if (firstName.lowercase().startsWith('F')) {
            this._firstName = firstName
        } else {
            this._firstName = "Lisa" // Avoid property setter.
            println("The name doesn't start with 'f' or 'F'")
        }
    }

    // Can we generate this outside of a data class?
    override fun toString() = "User(first=$firstName, last=$lastName, age=$age)"
}

fun main() {
    val fred = User("Fred", "Flintstone", 44)
    println("Fred: ${fred}")
    println("Name: ${fred.firstName}")
    val bart = User("Bart", "Simpson", 10)
    println("Bart: ${bart}")
    println("Name: ${bart.firstName}")
    bart.firstName = "Bart"
    println("Bart': ${bart}")
    println("Name: ${bart.firstName}")
}
