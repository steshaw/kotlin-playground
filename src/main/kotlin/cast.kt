fun lengthWhenString(a: Any?) : Int {
    return if (a is String) {
        a.length
    } else {
        0
    }
}

fun main() {
    println(lengthWhenString(1))
    println(lengthWhenString(null))
    println(lengthWhenString(""))
    println(lengthWhenString("abc"))
}