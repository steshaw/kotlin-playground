import kotlin.Exception

fun main() {
    println(listOf(1, 2, 3).filter { it < 21 }.size)
    println(listOf(1, 2, 3).count() { it < 21 })

    println("---")
    val people = listOf(
        Person("Wilma", 40),
        Person("Fred", 42),
    )
    println(people.sortedBy { it.age })
    println(people.sortedBy { it.age }.reversed())
    println(people.sortedByDescending { it.age })

    println("---")
    println(people
        .map { person ->
            person.takeIf { it.age == 42 }?.name
        }
        .filterNotNull()
    )
    println(people.asSequence().filter { it.age == 42 }.map { it.name }.toList())
    println(people.mapNotNull { person ->
        (person.takeIf { it.age == 42 })?.name
    })

    println("---")
    run {
        val map = mutableMapOf<Int, MutableList<Person>>()
        val person = Person("Fred", 42)
        if (person.age !in map) {
            map[person.age] = mutableListOf()
        }
        map.getValue(person.age) += person
        println(map)
    }
    run {
        val map = mutableMapOf<Int, MutableList<Person>>()
        val person = Person("Fred", 42)
        map.putIfAbsent(person.age, mutableListOf(person))
        println(map)
    }

    println("---")
    run {
        val map = mutableMapOf<Int, MutableList<Person>>()
        for (person in people) {
            if (person.age !in map) {
                map[person.age] = mutableListOf()
            }
            map.getValue(person.age) += person
        }
        println(map)
    }
    run {
        val map: Map<Int, List<Person>> = people.groupBy(Person::age)
        println(map)
    }
    run {
        val map0: Map<Int, List<Person>> = people.groupBy(Person::age)
        val map1 = map0.mapValues { (k, v) -> v.toMutableList() }
        val group = map1[42]
        if (group != null) {
            group += Person("Barney", 40)
        }
        println(map1)
        try {
            val g = map1.getValue(27) // Explodes!
            println(g)
        } catch (e: Exception) {
            println("getValue on map exploded: $e")
        }
    }

    println("---")
    run {
        val ps = people
            .asSequence()
            .groupBy { it.age }
            .mapValues { (_, group) -> group.size }
        println(ps)
    }
    run {
        val ps = people
            .asSequence()
            .groupingBy { it.age }
            .eachCount()
        println(ps)
    }
}
