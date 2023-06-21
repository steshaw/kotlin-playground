//
// Adapted from https://youtrack.jetbrains.com/issue/KT-10455/Kotlin-allows-use-of-class-members-before-initialization-leading-to-runtime-exceptions-including-NPEs-on-non-null-types
//

class Xyz {
    val nonNull: String

    init {
        this.crash()
        nonNull = "Initialized"
    }

    fun crash() {
        nonNull.length // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "this.s" is null
    }
}

fun main() {
    Xyz()
}
