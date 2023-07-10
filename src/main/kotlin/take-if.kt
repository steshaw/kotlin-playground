import Status.*

enum class Status { OPEN, CLOSED }
data class Issue(
    val id: Int,
    val status: Status,
)

fun main() {
    val issues = listOf(
        Issue(1, OPEN),
        Issue(2, CLOSED),
        Issue(3, OPEN),
    )

    fun openIssues(issues: List<Issue>) {
        issues.filter { it.status == OPEN }
            .takeIf { it.isNotEmpty() }
            ?.let { println("There are some open issues") }
    }

    println("Some open:")
    openIssues(issues) // there are some open issues
    val allClosed = issues.map {
        if (it.status == OPEN) Issue(it.id, CLOSED) else it
    }
    println("All closed:")
    openIssues(allClosed) // Prints nothing
}
