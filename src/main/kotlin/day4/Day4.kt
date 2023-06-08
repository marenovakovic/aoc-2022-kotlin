package day4

typealias PairAssignment = Pair<Assignment, Assignment>
typealias Assignment = IntRange

fun String.toPairAssignment(): PairAssignment =
    split(',')
        .map { it.first().digitToInt()..it.last().digitToInt() }
        .let { it.first() to it.last() }

fun overlaps(a: Assignment, b: Assignment) =
    a.intersect(b).isNotEmpty()
