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

data class Pair<A, B>(val a: A, val b: B)

fun main() {
    val p = Person("Fred", 44)
    println(p)

    val (name1, age1) = p
    println("$name1 $age1")

    val (name2, age2) = with (p) {
        Pair(name, age)
    }
    println("$name2 $age2")

   with (p) {
       println("$name $age")
    }
    println("$name2 $age2")

    val frizz = Cat("Frizz", false)
    val (name3, fur1) = frizz
    println("$name3 is ${if (fur1) "furry"  else "bald"}")
    printCat(frizz)

    for (pet in listOf(fluffy(), flappy())) {
        when (pet) {
            is Cat -> {
                val (name, fur) = pet
                println("$name is fur=$fur")
                printCat(pet)
            }

            is Dog -> {
                val (name, age) = pet
                println("$name is $age years old")
            }
        }
    }
}