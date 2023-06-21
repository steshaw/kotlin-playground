fun main() {
    val xs = listOf("one", "two", "three")
    println(xs.find{it == "four"}?.length)
}
