package day3

import readInput

typealias Item = Char
typealias Rucksack = String
typealias Group = Triple<Rucksack, Rucksack, Rucksack>

fun compartments(rucksack: Rucksack) =
    rucksack.substring(0, rucksack.length / 2) to rucksack.substring(rucksack.length / 2)

fun priority(i: Item) =
    if (i.isLowerCase()) i.code - 96 else (i.code - 65 + 27)

fun priority(items: List<Item>) =
    items.sumOf { priority(it) }

fun commonItems(pair: Pair<String, String>) =
    pair.first.toSet().intersect(pair.second.toSet()).toList()

fun splitIntoGroups(rucksacks: List<Rucksack>) =
    rucksacks.chunked(3) { (first, second, third) -> Group(first, second, third) }

fun readTestInput() =
    readInput("day3/test_input.txt").lines()

fun readRealInput() =
    readInput("day3/input.txt").lines()
