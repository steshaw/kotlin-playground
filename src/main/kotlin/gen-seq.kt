fun main() {
    val xs = generateSequence(3) { n ->
        println("Generating element...")
        (n + 1).takeIf { it < 7 }
    }
    println("take 0")
    println(xs.take(0).toList())
    println("take 1")
    println(xs.take(1).toList())
    println("take 2")
    println(xs.take(2).toList())
    println("toList")
    println(xs.toList())

    val ys = sequenceOf(1, 2, 3)
    println(ys)
    println(ys.toList())

    val zs = sequence {
        var i = 0
        while (true) {
            yield(i++)
        }
    }
    println(zs.take(5).toList())


    fun mySequence() = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(3..5)
        println("yield a list")
        yieldAll(listOf(7, 9))
    }

    println("---")
    println(mySequence()
        .map { it * it }
        .filter { it > 10 }
        .take(1))
}

