package day4

import readInput

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

fun overlaps(pairAssignment: PairAssignment) =
    overlap(pairAssignment).isNotEmpty()

private fun overlap(pairAssignment: PairAssignment) =
    pairAssignment.first.intersect(pairAssignment.second)

fun isFullOverlap(pairAssignment: PairAssignment): Boolean {
    val overlap = overlap(pairAssignment)
    return overlap.size == pairAssignment.first.count() ||
            overlap.size == pairAssignment.second.count()
}

fun testLines() = readInput("day4/test_input.txt").lines()
fun realLines() = readInput("day4/input.txt").lines()
