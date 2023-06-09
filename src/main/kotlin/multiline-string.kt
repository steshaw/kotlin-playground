// See https://github.com/bennyhuo/Kotlin-Trim-Indent#trim-indent

infix fun String.shouldEq(b : String) {
    if (this != b) {
        throw RuntimeException("Argh")
    }
}

fun example1() {
    val s1 = """
        hello
        world
        !!!
    """.trimIndent()
    println("s1 =\n$s1")
    s1 shouldEq "hello\nworld\n!!!"

    val s2 = """
        $s1
        hello2
        world2
        !!!
    """.trimIndent()
    println("s2 =\n$s2")
    val r = """
                hello
        world
        !!!
                hello2
                world2
                !!!
    """.trimIndent()
    println("r =\n$r")

    s2 shouldEq r
}

fun example2() {
    val s1 = """
        if (a > 1) {
            return true
        }
    """.trimIndent()
    println("s1 =\n${s1}")
    val s2 = """
        def test(a) {
            $s1
        }
    """.trimIndent()
    println("s2 =\n${s2}")

    val s3 = """
        class Test {
            $s2
        }
    """.trimIndent()
    println("s3 =\n${s3}")

    // Oh, dear!
    val r = """
                class Test {
                            def test(a) {
                    if (a > 1) {
            return true
        }
                }
                }
    """.trimIndent()
    println("r =\n$r")
    s3 shouldEq r

    // We want this:
    val result = """
        class Test {
            def test(a) {
                if (a > 1) {
                    return true
                }
            }
        }
    """.trimIndent()
    println("result =\n${result}")
    // We cannot assert this yet!
    if (false) s3 shouldEq result
}

fun main() {
    example1()
    example2()
}