import day2.Paper
import day2.Rock
import day2.Scissors
import day2.readStrategy
import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun `parse input`() {
        val strategy = readStrategy("day2/test_input.txt")
        val expectedStrategy = listOf(
            Rock to Paper,
            Paper to Rock,
            Scissors to Scissors,
        )
        assertEquals(expectedStrategy, strategy)
    }
}
