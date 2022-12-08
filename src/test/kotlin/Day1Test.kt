import day1.findMaxCalories
import day1.findCaloriesForTopThreeElves
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun partOne() {
        assertEquals(1000, findMaxCalories("1000"))
        assertEquals(2000, findMaxCalories("1000\n\n2000"))
        assertEquals(2000, findMaxCalories("2000\n\n1000"))
        assertEquals(3000, findMaxCalories("2000\n\n1000\n\n3000"))
        assertEquals(3000, findMaxCalories("2000\n1000"))
        assertEquals(3000, findMaxCalories("2000\n1000\n\n1000"))
        assertEquals(2000, findMaxCalories("1000\n\n1000\n1000"))

        val testInput = readInput("day1/test_input.txt")
        assertEquals(24000, findMaxCalories(testInput))
    }

    @Test
    fun partTwo() {
        assertEquals(3000, findCaloriesForTopThreeElves("1000\n\n1000\n\n1000"))
        assertEquals(4000, findCaloriesForTopThreeElves("1000\n\n1000\n\n2000"))
        assertEquals(4000, findCaloriesForTopThreeElves("1000\n\n1000\n\n2000\n\n500"))
        assertEquals(5000, findCaloriesForTopThreeElves("1000\n\n1000\n\n2000\n\n500\n\n2000"))

        val testInput = readInput("day1/test_input.txt")
        assertEquals(45000, findCaloriesForTopThreeElves(testInput))
    }
}
