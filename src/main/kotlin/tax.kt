import kotlin.IllegalArgumentException
import kotlin.math.floor
import kotlin.math.round

data class Tax(val income: Double, val base: Double, val multiplier: Double)

fun mkTable(): List<Tax> {
    fun c(i: Double, a: Double, b: Double): Tax {
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

fun VLOOKUP(income: Double, table: List<Tax>, position: Int): Double {
    val tax = getTax(income, table)
    return when (position) {
        2 -> tax.multiplier
        3 -> tax.base
        else -> throw IllegalArgumentException("Got position $position")
    }
}

private fun getTax(income: Double, table: List<Tax>) =
    table.reversed().find { income > it.income }!!

fun endsWith33Cents(d: Double): Boolean {
    // Oh, horrors
    val s = d.toString()
    val split = s.split(".")
    return split.size == 2 && split[1] == "33"
}

// Add 0.01 if the amount ends with 33 cents
private fun getAdjustedMonthlyIncome(monthlyIncome: Double) =
    monthlyIncome + if (endsWith33Cents(monthlyIncome)) 0.01 else 0.0

fun getMultiplier(a: Double) = getTax(a, scale2Table).multiplier
fun getBase(a: Double) = getTax(a, scale2Table).base

fun monthlyWithholding(monthlyIncome: Double): Double {
    val adjustedMonthlyIncome = getAdjustedMonthlyIncome(monthlyIncome)
    println("adjustedMonthlyIncome = $adjustedMonthlyIncome")
    val weeklyIncome = floor((3.0 / 13.0) * adjustedMonthlyIncome)
    println("weeklyIncome = $weeklyIncome")
    val multiplier = VLOOKUP(weeklyIncome, scale2Table, 2)
    val base = VLOOKUP(weeklyIncome, scale2Table, 3)
    return round(round((weeklyIncome + 0.99) * multiplier - base) * (13.0 / 3.0))
}

fun main() {
    println(VLOOKUP(2019.00, scale2Table, 2))
    println(VLOOKUP(2019.00, scale2Table, 3))

    fun p(monthlyIncome: Double) {
        val monthlyWithholding = monthlyWithholding(monthlyIncome)
        val net = monthlyIncome - monthlyWithholding
        println("gross = $monthlyIncome withholding=$monthlyWithholding net=$net")
    }
    p(8000.33)
    p(8750.00)
    p(9000.00)
    p(12000.00)
}
