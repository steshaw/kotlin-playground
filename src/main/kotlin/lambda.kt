fun main() {
    val m = mapOf(
        1 to "one",
        2 to "two",
    )
    println(m.mapValues { entry -> "[[${entry.key}: ${entry.value}]]" })
    println(m.mapValues { (k, v) -> "[[$k: $v]]" })
    println(m.mapValues { (_, v) -> "$v!" })
}