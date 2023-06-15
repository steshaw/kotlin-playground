fun lengthWhenString(a: Any?) : Int {
    if (a is String) {
        val s = a
        return s.length
    }
    return 0
}

fun main() {
    println(lengthWhenString(1))
    println(lengthWhenString(null))
    println(lengthWhenString(""))
    println(lengthWhenString("abc"))
}