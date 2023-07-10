fun main() {
    run {
        fun fail(msg: String) {
            throw Exception(msg)
        }

        val i = 99
        // Thankfully there is a warning here as result is inferred to be Any.
        val result = if (i >= 42) {
            42
        } else {
            fail("oops")
        }

        println(result)
    }
    run {
        fun fail(msg: String): Nothing {
            throw Exception(msg)
        }

        val i = 99
        // Yah, now result is inferred to be Int!
        val result = if (i >= 42) {
            42
        } else {
            fail("oops")
        }

        println(result)
    }
}
