data class Foo(val a: String, val b: String, val c: String)

// It breaks the "law of least surprise" that when destructuring with less than
// the correct number of components is not rejected by the compiler.
fun structs() {
    val f = Foo("a", "b", "c")
    println("f = $f")

    val (a0) = Foo("a", "b", "c")
    println("a0 = $a0")

    val (a1, b1) = Foo("a", "b", "c")
    println("a1 = $a1, b1 = $b1")

    val (a2, b2, c2) = Foo("a", "b", "c")
    println("a2 = $a2, b2 = $b2, c2 = $c2")
}

// It breaks the "law of least surprise" that you can destructure lists this way at all.
fun lists() {
    val (a2) = listOf("a", "b")
    println("a2 = $a2") // Nuts

    val (a1, b1) = listOf("a", "b")
    println("a1 = $a1, b1 = $b1") // Nuts

    try {
        val (a3, b3, c3) = listOf("a", "b")
        println("a3 = $a3, b3 = $b3, c3 = $c3") // Explodes!
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Out of bounds! $e")
    }
}

fun main() {
    structs()
    lists()
}
