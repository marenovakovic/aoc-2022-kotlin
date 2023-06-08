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

infix fun Assignment.overlaps(other: Assignment) =
    first <= other.last && other.first <= last

private infix fun Assignment.overlap(other: Assignment) =
    this.intersect(other)

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

private fun testLines() = readInput("day4/test_input.txt").lines()

fun solvePartOneRealInput() =
    realLines()
        .map { it.toPairAssignment() }
        .count(::isFullOverlap)

private fun realLines() = readInput("day4/input.txt").lines()
