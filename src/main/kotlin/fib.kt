fun fibonacci(): Sequence<Int> = sequence {
    var i = 0
    var j = 1
    while (true) {
        yield(i)
        val v = i + j
        i = j
        j = v
    }
}

infix fun String.eq(right: String) {
    if (this == right) {
        println("Okay")
    } else {
        throw Exception("Oops, $this does not equal $right")
    }
}

fun main() {
    fibonacci().take(4).toList().toString() eq
        "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
        "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}
