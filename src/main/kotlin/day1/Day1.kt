package day1

import readInput

fun main() {
    val input = readInput("day1/input.txt")
    println(partOne(input))
}

fun partOne(input: String) =
    input
        .split("\n\n")
        .map(String::lines)
        .map { it.map(String::toInt) }
        .maxOf(List<Int>::sum)
