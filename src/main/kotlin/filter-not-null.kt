fun main() {
    val xs: List<Int?> = listOf(1, 2, null, 4)
    println(xs) // [1, 2, null, 4]
    val xs2 : List <Int> = xs.filterNotNull() // Like `catMaybes`.
    println(xs2) // [1, 2, 4]
}
