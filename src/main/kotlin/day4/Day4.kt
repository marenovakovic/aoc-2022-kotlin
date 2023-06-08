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
    val (first, second) = pairAssignment
    return first.fullyContains(second) || second.fullyContains(first)
}

private fun Assignment.fullyContains(other: Assignment) =
    other.first in this && other.last in this

fun testLines() = readInput("day4/test_input.txt").lines()
fun realLines() = readInput("day4/input.txt").lines()
