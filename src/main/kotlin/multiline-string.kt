// See https://github.com/bennyhuo/Kotlin-Trim-Indent#trim-indent

infix fun String.shouldEq(b : String) {
    if (this != b) {
        throw RuntimeException("Argh")
    }
}

val trimIndentPlugin = true

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

    val badResult = """
                hello
        world
        !!!
                hello2
                world2
                !!!
    """.trimIndent()
    println("badResult =\n$badResult")
    if (!trimIndentPlugin) s2 shouldEq badResult

    val goodResult = """
        hello
        world
        !!!
        hello2
        world2
        !!!
    """.trimIndent()
    println("goodResult =\n$goodResult")
    if (trimIndentPlugin) s2 shouldEq goodResult
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
    val badResult = """
                class Test {
                            def test(a) {
                    if (a > 1) {
            return true
        }
                }
                }
    """.trimIndent()
    println("badResult =\n$badResult")
    if (!trimIndentPlugin) s3 shouldEq badResult

    // We want this:
    val goodResult = """
        class Test {
            def test(a) {
                if (a > 1) {
                    return true
                }
            }
        }
    """.trimIndent()
    println("goodResult =\n${goodResult}")
    // We cannot assert this yet!
    if (trimIndentPlugin) s3 shouldEq goodResult
}

fun main() {
    example1()
    example2()
}