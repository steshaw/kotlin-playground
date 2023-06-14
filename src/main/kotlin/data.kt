data class Person(
    val name: String,
    val age: Int,
)

sealed interface Pet
data class Dog(val name: String, val age: Int) : Pet
data class Cat(val name: String, val fur : Boolean) : Pet

fun fluffy(): Pet = Cat("Fluffy", true)
fun flappy(): Pet = Dog("Flappy", 4)

fun printCat(cat: Cat) {
    val (name, fur) = cat
    println("$name is ${if (fur) "furry"  else "bald"}")
}

fun main() {
    val p = Person("Fred", 44)
    println(p)

    val (name, age) = p
    println("$name $age")

    val frizz = Cat("Frizz", false)
    val (name1, fur1) = frizz
    println("$name1 is ${if (fur1) "furry"  else "bald"}")
    printCat(frizz)

    for (pet in listOf(fluffy(), flappy())) {
        when (pet) {
            is Cat -> {
                val (name2, fur2) = pet
                println("$name2 is fur=$fur2")
                printCat(pet)
            }

            is Dog -> {
                val (name3, age3) = pet
                println("$name3 is $age3 years old")
            }
        }
    }
}