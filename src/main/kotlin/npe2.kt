fun main() {
    println(A.s.length)
}

class A {
    companion object {
        val s: String = B.s
    }
}

class B {
    companion object {
        val s: String = A.s
    }
}
