//
// Adapted from https://youtrack.jetbrains.com/issue/KT-10455/Kotlin-allows-use-of-class-members-before-initialization-leading-to-runtime-exceptions-including-NPEs-on-non-null-types#focus=Comments-27-3869254.0-0
//

import java.lang.Exception

open class Foo1 {
    val nonNull: String

    init {
        this.method() // Error cannot use open function on constructor.
        nonNull = "Initialized"
    }

    open fun method() {
        nonNull.startsWith("foo")
    }
}

open class Foo2 {
    val nonNull: String

    init {
        nonNull = "Initialized"
        this.method1() // Error cannot use this function in constructor, it uses open "method2" on line ???.
    }

    fun method1() {
        nonNull.startsWith("foo")
        method2()
    }

    open fun method2() {
        nonNull.startsWith("foo")
    }
}

class Bar2 : Foo2() {
    private val s: String = "hi"

    override fun method2() {
        s.length // NPE
    }
}

class Foo3 {
    val nonNull: String

    init {
        this.method() // Variable 'nonNull' is used inside of this method, it must be initialized.
        nonNull = "Initialized"
    }

    fun method() {
        nonNull.startsWith("foo")
    }
}

// No problem because Foo4 cannot be subclassed (it is final/non-open).
class Foo4 {
    val nonNull: String

    init {
        nonNull = "Initialized"
        this.method()
    }

    fun method() {
        nonNull.startsWith("foo")
    }
}

fun printException(block: (() -> Unit)) {
    try {
        block()
        println("ok")
    } catch (e: Exception) {
        println("Caught $e")
    }
}

fun main() {
    println("Foo1")
    printException { Foo1() }
    println("Foo2")
    printException { Foo2() }
    println("Bar2")
    printException { Bar2() }
    println("Foo3")
    printException { Foo3() }
    println("Foo4")
    printException { Foo4() }
}
