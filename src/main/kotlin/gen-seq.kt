fun main() {
    val xs = generateSequence(3) { n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7}
    }
    println("take 0")
    println(xs.take(0).toList())
    println("take 1")
    println(xs.take(1).toList())
    println("take 2")
    println(xs.take(2).toList())
    println("toList")
    println(xs.toList())
}
