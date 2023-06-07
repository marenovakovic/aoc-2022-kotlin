package day4

fun parseSection(assignment: String): Pair<String, String> =
    assignment
        .split(',')
        .let { it.first() to it.last() }
