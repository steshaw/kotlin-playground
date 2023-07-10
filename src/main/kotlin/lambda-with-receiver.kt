inline fun <T> myApply(t: T, block: T.() -> Unit): T {
    t.block()
    return t
}

fun main() {
    println("original:")
    run {
        val sb = StringBuilder()
        sb.appendLine("Alphabet")
        for (c in 'a'..'z') {
            sb.append(c)
        }
        println(sb)
    }
    println("myApply:")
    run {
        val sb = StringBuilder()
        val r = myApply(sb) {
            appendLine("Alphabet")
            for (c in 'a'..'z') {
                append(c)
            }
        }
        println(r)
    }
    println("with:")
    run {
        val sb = StringBuilder()
        with(sb) {
            appendLine("Alphabet")
            for (c in 'a'..'z') {
                append(c)
            }
        }
        println(sb)
    }

    println("--- Lambda with receiver")
    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    println(isEven(5))
    val isOdd: Int.() -> Boolean = { this % 2 != 0 }
    println(5.isOdd())
    println(isOdd(5))
}
