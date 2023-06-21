fun main() {
    object {
        val foo: String

        init {
            println(fail()) // Print null even though fail() returns a non-nullable String
            foo = "foo"
        }

        fun fail(): String = foo // returns null during construction
    }
}
