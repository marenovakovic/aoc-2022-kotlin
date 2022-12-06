import day1.partOne
import day1.partTwo
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun partOne() {
        assertEquals(1000, partOne("1000"))
        assertEquals(2000, partOne("1000\n\n2000"))
        assertEquals(2000, partOne("2000\n\n1000"))
        assertEquals(3000, partOne("2000\n\n1000\n\n3000"))
        assertEquals(3000, partOne("2000\n1000"))
        assertEquals(3000, partOne("2000\n1000\n\n1000"))
        assertEquals(2000, partOne("1000\n\n1000\n1000"))

        val testInput = readInput("day1/test_input.txt")
        assertEquals(24000, partOne(testInput))
    }

    @Test
    fun partTwo() {
        assertEquals(3000, partTwo("1000\n\n1000\n\n1000"))
        assertEquals(4000, partTwo("1000\n\n1000\n\n2000"))
        assertEquals(4000, partTwo("1000\n\n1000\n\n2000\n\n500"))
        assertEquals(5000, partTwo("1000\n\n1000\n\n2000\n\n500\n\n2000"))
    }
}
