package day3

import readInput

fun compartments(s: String) = s.substring(0, s.length / 2) to s.substring(s.length / 2)

fun priority(c: Char) = if (c.isLowerCase()) c.code - 96 else (c.code - 65 + 27)

fun priority(chars: List<Char>) = chars.sumOf { priority(it) }

fun commonItems(pair: Pair<String, String>) = pair.first.toSet().intersect(pair.second.toSet()).toList()

fun readTestInput() =
    readInput("day3/test_input.txt").lines()

fun readRealInput() =
    readInput("day3/input.txt").lines()
