fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    val first = s[0]
    if (!first.isLetter() && first != '_') {
        return false
    }
    return s.all{c -> c.isLetter() || c.isDigit() || c == '_'}
}

println(isValidIdentifier("name"))   // true
println(isValidIdentifier("_name"))  // true
println(isValidIdentifier("_12"))    // true
println(isValidIdentifier(""))       // false
println(isValidIdentifier("012"))    // false
println(isValidIdentifier("no$"))    // false
