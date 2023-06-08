package day4

typealias PairAssignment = Pair<Assignment, Assignment>
typealias Assignment = IntRange

private val String.firstDigit get() = first().digitToInt()
private val String.lastDigit get() = last().digitToInt()

fun String.toPairAssignment() =
    split(',')
        .map(::sectionDigits)
        .let(::pairAssignment)

private fun sectionDigits(s: String) = s.firstDigit..s.lastDigit
private fun pairAssignment(assignments: List<Assignment>) = assignments.first() to assignments.last()

fun overlaps(a: Assignment, b: Assignment) =
    a.intersect(b).isNotEmpty()
