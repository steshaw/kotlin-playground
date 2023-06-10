sealed interface Expr
data class Constant(val i: Int) : Expr
data class Add(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr): Int =
    when (expr) {
        is Constant -> expr.i
        is Add -> eval(expr.left) + eval(expr.right)
        else -> throw RuntimeException("huh")
    }

val expr = Add(Constant(1), Add(Constant(20), Constant(21)))
println("${expr} = ${eval(expr)}")
