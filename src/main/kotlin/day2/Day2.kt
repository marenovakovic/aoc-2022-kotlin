package day2

import readInput

typealias Round = Pair<Play, Play>

fun Round(s: List<String>): Round {
    val (opponent, player) = s
    return Round(Play(opponent), Play(player))
}

sealed interface Play
object Rock : Play
object Paper : Play
object Scissors : Play

fun Play(s: String) =
    when (s) {
        "A", "X" -> Rock
        "B", "Y" -> Paper
        "C", "Z" -> Scissors
        else -> throw IllegalArgumentException("illegal play :$s")
    }

fun readStrategy(fileName: String) =
    readInput(fileName)
        .splitIntoRounds()
        .map(String::splitIntoPlays)
        .map(::Round)

private fun String.splitIntoRounds() = split('\n')

private fun String.splitIntoPlays() = split(' ')
