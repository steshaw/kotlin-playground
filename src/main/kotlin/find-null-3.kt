fun main() {
    fun <T> Iterable<T>.findAndPrint(predicate: (T) -> Boolean) {
        val item = find(predicate)
        if (item != null) {
            // Are we sure that we found it?
            println("item = $item")
        }
    }

    fun <T> findEm(xs: Iterable<T>) {
        xs.findAndPrint { it == 3 }
        xs.findAndPrint { it == 4 }
        xs.findAndPrint { it == null }
    }

    val xs: Iterable<Int?> = listOf(1, 2, 3, null, 5, 6, 7)
    println("xs")
    findEm(xs)
    val ys: Iterable<Int> = listOf(1, 2, 3, 4, 5, 6, 7)
    println("ys")
    findEm(ys)
}
