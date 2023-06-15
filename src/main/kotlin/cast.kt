fun lengthWhenString(a: Any?) : Int =
    (a as? String)?.length ?: 0

fun main() {
    println(lengthWhenString(1))
    println(lengthWhenString(null))
    println(lengthWhenString(""))
    println(lengthWhenString("abc"))
}