import Gender.* // Strange to be able to import from Gender which follows...

enum class Gender { MALE, FEMALE }

data class Hero(
    val name: String,
    val age: Int,
    val gender: Gender?,
)

val heroes = listOf(
    Hero("The Captain", 60, MALE),
    Hero("Frenchy", 42, MALE),
    Hero("The Kid", 9, null),
    Hero("Lady Lauren", 29, FEMALE),
    Hero("First Mate", 29, MALE),
    Hero("Sir Stephen", 37, MALE)
)

fun main() {
    val m = mapOf(
        1 to "one",
        2 to "two",
    )
    println(m.mapValues { entry -> "[[${entry.key}: ${entry.value}]]" })
    println(m.mapValues { (k, v) -> "[[$k: $v]]" })
    println(m.mapValues { (_, v) -> "$v!" })

    val xs = listOf(1, 2, 3)
    println(xs.map { it + 10 })

    val xs2 = listOf(1, 2, 3, null, 5)
    println(xs2.map { if (it == null) null else it + 10 })

    val xs3 = listOf(1, 2, 3, null, 1, 2, 3)
    println(xs3.find { it == 2 })
    println(xs3.withIndex().find { (_, v) -> v == 2 })

    // Fails the principle of least surprise here. We cannot tell if there was a null or not!
    println(xs3.find { it == null })
    val ys = listOf<Int?>(1, 2, 3, 4)
    println(ys.find { it == null })

    println(xs3.withIndex().find { (_, v) -> v == null })
    println(ys.withIndex().find { (_, v) -> v == null })

    println()
    println("associate")
    val intRange = 1..5
    val map = intRange.associate { ('a' + it) to (it + 10) }
    println(map.javaClass)
    println(map)

    println()
    println("zipWithNext")
    println(listOf<Int>().zipWithNext())
    println(listOf(1).zipWithNext())
    println(listOf(1, 2).zipWithNext())
    println(listOf(1, 2, 3).zipWithNext())
    println(listOf(1, 2, 3, 4).zipWithNext())
    println(listOf(1, 2, 3, 4, 5).zipWithNext())

    println()
    println("flatten")
    val flat = listOf(1..2, 4..5, 9..12).flatten()
    println(flat.javaClass)
    println(flat)

    println()
    println("flatMap")
    val m1 = (2..5).map { n -> (1..n).map { 'a' + it } }
    println(m1)
    val m2 = (2..5).flatMap { n -> (1..n).map { 'a' + it } }
    println(m2)

    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println("youngest = $youngest")
    println("oldest = $oldest")
    println(kotlin.Pair(youngest.size,oldest.size))
    println(youngest.size to oldest.size)

    val byAge = heroes.groupBy(Hero::age)
    println(byAge)
    val maxEntry = byAge.maxBy { (k, v) -> v.size }
    println(maxEntry)
    println(maxEntry.key)
    println(maxEntry.javaClass)

    val heroesMap: Map<String, Hero> = heroes.associateBy(Hero::name)
    println(heroesMap)
    println(heroesMap.javaClass)

    immediatelyInvoke()
}

private fun immediatelyInvoke() {
    println()
    println("immediately invoke lambda")
    // POLA violation: you can't remove the following dummy declaration.
    val _a = 1
    // POLA violation: you can't repeat the following statement.
    {
        println("hey!")
    }()
    // i.e. you cannot uncomment this block:
    /*
    {
        println("hey!")
    }()
     */

    // You can repeat the blocks if you bind the result to a variable.
    val a = {
        println("hey!")
    }()
    val b = {
        println("hey!")
    }()
    val c = {
        println("hey!")
    }()
    println((a to b) to c)

    // Using `run` works better. It can be repeated without running into compilation errors.
    run {
        println("hey!")
    }
    run {
        println("hey!")
    }
    run {
        println("hey!")
    }
}
