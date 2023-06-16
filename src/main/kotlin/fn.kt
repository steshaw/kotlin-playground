fun isEven(i: Int) = i % 2

fun main() {
  // The following is illegal in Kotlin:
  //val f = isEven
  // , but it works when using the function reference syntax.
  val f = ::isEven
  println(f(1))
  println(f(2))
}
