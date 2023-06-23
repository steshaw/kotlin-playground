fun main() {
    fun <T> Iterable<T>.findAndPrint(x: T) {
        if (this.any { it == x }) {
            println(x)
        }
    }

    fun <T> findEm(xs: Iterable<T>) {
        xs.findAndPrint(3)
        xs.findAndPrint(4)
        xs.findAndPrint(null)
    }

    val l1: Iterable<Int?> = listOf(1, 2, 3, null, 5, 6, 7)
    println("l1")
    findEm(l1)
    val l2: Iterable<Int> = (1..7).toList()
    println("l2")
    findEm(l2)
}
