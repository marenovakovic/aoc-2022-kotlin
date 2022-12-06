package day1

import readInput

fun main() {
    val input = readInput("day1/input.txt")

    println(partOne(input))
    println(partTwo(input))
}

fun partOne(input: String) =
    input
        .sumOfCaloriesPerElf()
        .max()

fun partTwo(input: String) =
    input
        .sumOfCaloriesPerElf()
        .topElves(3)

private fun String.sumOfCaloriesPerElf() =
    caloriesPerElf()
        .map(String::lines)
        .map { it.map(String::toInt) }
        .map(List<Int>::sum)

private fun String.caloriesPerElf() =
    split("\n\n")

private fun List<Int>.topElves(n: Int) =
    sortedDescending()
        .take(n)
        .sum()
