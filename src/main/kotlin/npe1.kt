fun main() {
    N()
}

abstract class M {
    constructor() {
        print() // Leaking `this`
    }

    abstract fun print()
}

class N : M() {
    val s: String = "abc"
    override fun print() {
        println(s.length)
    }
}
