import kotlin.IllegalArgumentException
import kotlin.math.floor
import kotlin.math.round

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

val scale2Table = mkTable()

fun VLOOKUP(income: Double, table: List<Tax>, position: Int) : Double {
    val tax = table.reversed().find { income > it.income }!!
    return when (position) {
        2 -> tax.multiplier
        3 -> tax.base
        else -> throw IllegalArgumentException("Got position $position")
    }
}

fun IF(condition: Boolean, value_if_true: Double, value_if_false: Double) : Double{
    return if (condition) value_if_true else value_if_false
}

fun SEARCH(s: String, d: Double) : Boolean {
    return false
}
fun ISNUMBER(b: Boolean) : Boolean {
    return b
}

fun monthlyWithholding(monthlyIncome: Double): Double {
    val adjustedMonthlyIncome = monthlyIncome + IF(ISNUMBER(SEARCH(".33", monthlyIncome)), 0.01, 0.0)
    val weeklyIncome = floor((3.0 / 13.0) * adjustedMonthlyIncome)
    println("weeklyIncome = $weeklyIncome")
    val multiplier = VLOOKUP(weeklyIncome, scale2Table, 2)
    val base = VLOOKUP(weeklyIncome, scale2Table, 3)
    val monthlyWithholding =
        round(round((weeklyIncome + 0.99) * multiplier - base) * (13.0 / 3.0))
    return monthlyWithholding
}

fun main() {
    println(VLOOKUP(2019.00,scale2Table, 2))
    println(VLOOKUP(2019.00,scale2Table, 3))

    fun p(monthlyIncome: Double) {
        val monthlyWithholding = monthlyWithholding(monthlyIncome)
        val net = monthlyIncome - monthlyWithholding
        println("gross = $monthlyIncome withholding=$monthlyWithholding net=$net")
    }
    p(8750.00)
    p(9000.00)
    p(12000.00)
}
