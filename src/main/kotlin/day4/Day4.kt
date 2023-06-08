package day4

import readInput

typealias PairAssignment = Pair<Assignment, Assignment>
typealias Assignment = IntRange

fun String.toPairAssignment() =
    split(',')
        .map(::sectionDigits)
        .let(::pairAssignment)

private fun sectionDigits(s: String) =
    s.substringBefore('-').toInt()..s.substringAfter('-').toInt()

private fun pairAssignment(assignments: List<Assignment>) =
    assignments.first() to assignments.last()

private fun overlaps(pairAssignment: PairAssignment) =
    pairAssignment.first overlaps pairAssignment.second

infix fun Assignment.overlaps(other: Assignment) =
    first <= other.last && other.first <= last

fun isFullOverlap(pairAssignment: PairAssignment): Boolean {
    val (first, second) = pairAssignment
    return first fullyOverlaps second || second fullyOverlaps first
}

private infix fun Assignment.fullyOverlaps(other: Assignment) =
    first <= other.first && last >= other.last

fun solvePartOneTestInput() =
    testLines()
        .map { it.toPairAssignment() }
        .count(::isFullOverlap)

fun solvePartTwoTestInput() =
    testLines()
        .map { it.toPairAssignment() }
        .count(::overlaps)

fun solvePartOneRealInput() =
    realLines()
        .map { it.toPairAssignment() }
        .count(::isFullOverlap)

fun solvePartTwoRealInput() =
    realLines()
        .map { it.toPairAssignment() }
        .count(::overlaps)

private fun testLines() =
    readInput("day4/test_input.txt").lines()

private fun realLines() =
    readInput("day4/input.txt").lines()
