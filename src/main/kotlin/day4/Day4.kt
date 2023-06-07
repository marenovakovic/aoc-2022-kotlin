package day4

typealias PairAssignment = String
typealias Assignment = IntRange

fun parseSection(pairAssignment: PairAssignment): Pair<Assignment, Assignment> =
    pairAssignment
        .split(',')
        .map { it.first().digitToInt()..it.last().digitToInt() }
        .let { it.first() to it.last() }
