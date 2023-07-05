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

private fun getTax(income: Double, table: List<Tax>) =
    table.reversed().find { income > it.income }!!

// Add 0.01 if the amount ends with 33 cents
private fun getAdjustedMonthlyIncome(monthlyIncome: Double) =
    monthlyIncome +
        if (monthlyIncome.toString().endsWith(".33"))
            0.01
        else 0.0

fun monthlyWithholding(monthlyIncome: Double): Double {
    val adjustedMonthlyIncome = getAdjustedMonthlyIncome(monthlyIncome)
    println("adjustedMonthlyIncome = $adjustedMonthlyIncome")
    val weeklyIncome = floor((3.0 / 13.0) * adjustedMonthlyIncome)
    println("weeklyIncome = $weeklyIncome")
    val tax = getTax(weeklyIncome, scale2Table)
    println("tax = $tax")
    val weeklyWithholding = round((weeklyIncome + 0.99) * tax.multiplier - tax.base)
    return round(weeklyWithholding * (13.0 / 3.0))
}

fun main() {
    val tax = getTax(2019.00, scale2Table)
    println(tax)

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
