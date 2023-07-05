import kotlin.random.Random

data class Email(val email: String)

fun getEmail() : Email? =
    if (Random.nextBoolean()) Email("steven@steshaw.org") else null

fun send(email: Email) {
    println("Sending to $email")
}

fun main() {
    val email = getEmail()
    email?.let { send(it) }
}
