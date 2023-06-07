package day4

typealias Assignment = String

fun parseSection(assignment: Assignment): Pair<IntRange, IntRange> =
    assignment
        .split(',')
        .map { it.first().digitToInt()..it.last().digitToInt() }
        .let { it.first() to it.last() }
