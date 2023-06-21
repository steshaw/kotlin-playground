fun main() {
    val xs: List<Int?> = listOf(1, 2, 3, null, 5, 6, 7)
    val ys: List<Int?> = listOf(1, 2, 3, 4, 5, 6, 7)
    println(xs)
    println(xs.find { it == 3 })
    println(ys.find { it == 3 })
    println(xs.find { it == 4 })
    println(ys.find { it == 4 })
    println(xs.find { it == null }) // Is the null found or not?
    println(ys.find { it == null }) // Is the null found or not?
}
