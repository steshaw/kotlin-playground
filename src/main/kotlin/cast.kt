fun lengthWhenString(a: Any?) : Int {
    if (a is String) {
        return a.length
    } else {
        return 0
    }
}

fun main() {
    println(lengthWhenString(1))
    println(lengthWhenString(null))
    println(lengthWhenString(""))
    println(lengthWhenString("abc"))
}