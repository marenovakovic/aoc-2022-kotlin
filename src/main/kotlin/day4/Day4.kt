package day4

typealias PairAssignment = String

fun parseSection(pairAssignment: PairAssignment): Pair<IntRange, IntRange> =
    pairAssignment
        .split(',')
        .map { it.first().digitToInt()..it.last().digitToInt() }
        .let { it.first() to it.last() }
