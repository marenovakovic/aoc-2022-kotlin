package day1

import readInput

fun main() {
    val input = readInput("day1/input.txt")

    println(partOne(input))
    println(partTwo(input))
}

fun partOne(input: String) =
    input
        .caloriesPerElf()
        .max()

fun partTwo(input: String) =
    input
        .caloriesPerElf()
        .sortedDescending()
        .take(3)
        .sum()

private fun String.caloriesPerElf() =
    listOfCaloriesPerElf()
        .map(String::lines)
        .map { it.map(String::toInt) }
        .map(List<Int>::sum)

private fun String.listOfCaloriesPerElf() =
    split("\n\n")
