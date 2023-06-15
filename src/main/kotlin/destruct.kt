data class Foo(val a: String, val b: String, val c: String)

// It breaks the "law of least surprise" when destructuring with less than the correct number of components
// is not rejected by the compiler.
fun main() {
    val f = Foo("a", "b", "c")
    println("f = $f")

    val (a0) = Foo("a", "b", "c")
    println("a0 = $a0")

    val (a1, b1) = Foo("a", "b", "c")
    println("a1 = $a1, b1 = $b1")

    val (a2, b2, c2) = Foo("a", "b", "c")
    println("a2 = $a2, b2 = $b2, c2 = $c2")
}
