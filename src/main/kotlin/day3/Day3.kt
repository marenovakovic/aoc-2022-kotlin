package day3

import readInput

typealias Item = Char
typealias Rucksack = String
typealias Compartment = Pair<String, String>
typealias Group = Triple<Rucksack, Rucksack, Rucksack>

fun compartments(rucksack: Rucksack) =
    rucksack.substring(0, rucksack.length / 2) to rucksack.substring(rucksack.length / 2)

fun priority(i: Item) =
    if (i.isLowerCase()) i.code - 96 else (i.code - 65 + 27)

fun priority(items: List<Item>) =
    items.sumOf { priority(it) }

fun commonItems(compartment: Compartment) =
    compartment.first.toSet().intersect(compartment.second.toSet()).toList()

fun splitIntoGroups(rucksacks: List<Rucksack>) =
    rucksacks.chunked(3) { (first, second, third) -> Group(first, second, third) }

fun findGroupBadge(group: Group): List<Item> {
    val (first, second, third) = group
    val firstSecondCommon = commonItems(first to second).joinToString()
    val secondThirdCommon = commonItems(second to third).joinToString()
    return commonItems(firstSecondCommon to secondThirdCommon).filter(Item::isLetter)
}

fun readTestInput() =
    readInput("day3/test_input.txt").lines()

fun readRealInput() =
    readInput("day3/input.txt").lines()
