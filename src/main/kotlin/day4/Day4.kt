package day4

typealias Assignment = String

fun parseSection(assignment: Assignment): Pair<String, String> =
    assignment
        .split(',')
        .let { it.first() to it.last() }
