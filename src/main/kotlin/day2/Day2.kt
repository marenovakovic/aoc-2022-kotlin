package day2

import readInput

typealias Round = Pair<Play, Play>

val Round.player
    get() = second

private fun Round(s: List<String>): Round {
    val (opponent, player) = s
    return Round(Play(opponent), Play(player))
}

private val Round.score
    get() = Result(this).score + player.score

sealed class Play(val score: Int)
object Rock : Play(1)
object Paper : Play(2)
object Scissors : Play(3)

sealed class Result(val score: Int)
object Win : Result(6)
object Draw : Result(3)
object Loss : Result(0)

private fun Result(round: Round) =
    when (round) {
        Rock to Paper -> Win
        Rock to Scissors -> Loss
        Paper to Scissors -> Win
        Paper to Rock -> Loss
        Scissors to Rock -> Win
        Scissors to Paper -> Loss
        Rock to Rock -> Draw
        Paper to Paper -> Draw
        Scissors to Scissors -> Draw
        else -> throw IllegalArgumentException("invalid round: $round")
    }

private fun Play(s: String) =
    when (s) {
        "A", "X" -> Rock
        "B", "Y" -> Paper
        "C", "Z" -> Scissors
        else -> throw IllegalArgumentException("illegal play :$s")
    }

fun playAssumedStrategy(fileName: String) =
    readAssumedStrategy(fileName).sumOf(Round::score)

fun readAssumedStrategy(fileName: String) =
    readInput(fileName)
        .splitIntoRounds()
        .map(String::splitIntoPlays)
        .map(::Round)

private fun String.splitIntoRounds() = split('\n')
private fun String.splitIntoPlays() = split(' ')
