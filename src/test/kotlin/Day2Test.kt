import day2.Draw
import day2.Loss
import day2.Paper
import day2.Rock
import day2.Scissors
import day2.Win
import day2.playActualStrategy
import day2.playAssumedStrategy
import day2.readActualStrategy
import day2.readAssumedStrategy
import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun `parse assumed strategy`() {
        val strategy = readAssumedStrategy("day2/test_input.txt")

        val expectedStrategy = listOf(
            Rock to Paper,
            Paper to Rock,
            Scissors to Scissors,
        )
        assertEquals(expectedStrategy, strategy)
    }

    @Test
    fun `play assumed test game`() {
        val score = playAssumedStrategy("day2/test_input.txt")

        assertEquals(15, score)
    }

    @Test
    fun `play assumed game (part one)`() {
        val score = playAssumedStrategy("day2/input.txt")

        assertEquals(12458, score)
    }

    @Test
    fun `parse actual strategy`() {
        val strategy = readActualStrategy("day2/test_input.txt")

        val expectedStrategy = listOf(
            Rock to Draw,
            Paper to Loss,
            Scissors to Win,
        )
        assertEquals(expectedStrategy, strategy)
    }

    @Test
    fun `play actual test game`() {
        val score = playActualStrategy("day2/test_input.txt")

        assertEquals(12, score)
    }

    @Test
    fun `play actual game (part two)`() {
        val score = playActualStrategy("day2/input.txt")

        assertEquals(12683, score)
    }
}
