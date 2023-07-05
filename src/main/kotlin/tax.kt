data class Tax (val income: Double, val base: Double, val multiplier: Double)

fun mkTable(): List<Tax> {
    fun c(i: Double, a: Double , b: Double) :Tax {
        return Tax(income = i, base = b, multiplier = a)
    }

    return listOf(
        c(0.00, 0.0000, 0.0000),
        c(359.00, 0.1900, 68.3462),
        c(438.00, 0.2900, 112.1942),
        c(548.00, 0.2100, 68.3465),
        c(721.00, 0.2190, 74.8369),
        c(865.00, 0.3477, 186.2119),
        c(1282.00, 0.3450, 182.7504),
        c(2307.00, 0.3900, 286.5965),
        c(3461.00, 0.4700, 563.5196),
    )
}

val LU_Scale2 = mkTable()

fun ROUND(a: Double, places: Int) : Double {
    return a
}
fun TRUNC(a: Double, places: Int) : Double {
    return a
}
fun VLOOKUP(a: Double, table: List<Tax>, position: Int) : Double {
    return 0.0
}

fun IF(condition: Boolean, value_if_true: Double, value_if_false: Double) : Double{
    if (condition) return value_if_true else return value_if_false
}
val U3 = 8750.00

fun SEARCH(s: String, d: Double) : Boolean {
    return false
}
fun ISNUMBER(b: Boolean) : Boolean {
    return b
}

val trunc :Double =
    TRUNC((3.0 / 13.0) * (U3 + IF(ISNUMBER(SEARCH(".33", U3)), 0.01, 0.0)), 0)
val monthlyWithholding =
    ROUND(ROUND((trunc + 0.99) * (VLOOKUP(trunc, LU_Scale2, 2)) - (VLOOKUP(trunc, LU_Scale2, 3)), 0) * (13.0 / 3.0), 0)

fun main() {
    println(monthlyWithholding)
}
