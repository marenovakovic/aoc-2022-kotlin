package day1

import readInput

fun main() {
    val input = readInput("day1/input.txt")

    println(findMaxCalories(input))
    println(findCaloriesForTopThreeElves(input))
}

fun findMaxCalories(inventory: String) =
    inventory
        .sumCaloriesPerElf()
        .max()

fun findCaloriesForTopThreeElves(inventory: String) =
    inventory
        .sumCaloriesPerElf()
        .topElves(3)

private fun String.sumCaloriesPerElf() =
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
