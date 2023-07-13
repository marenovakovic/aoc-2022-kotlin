import day4.isFullOverlap
import day4.overlaps
import day4.solvePartOneRealInput
import day4.solvePartOneTestInput
import day4.solvePartTwoRealInput
import day4.solvePartTwoTestInput
import day4.toPairAssignment
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

class Day4Test : DescribeSpec({
    context("part one") {
        it("can parse assignment") {
            "2-4,6-8".toPairAssignment() shouldBeEqual (2..4 to 6..8)
            "1-3,5-7".toPairAssignment() shouldBeEqual (1..3 to 5..7)
            "8-9,9-9".toPairAssignment() shouldBeEqual (8..9 to 9..9)
        }
        it("overlap") {
            2..4 overlaps 2..3 shouldBeEqual true
            3..3 overlaps 2..8 shouldBeEqual true
            2..4 overlaps 3..5 shouldBeEqual true
            2..4 overlaps 5..7 shouldBeEqual false
            5..7 overlaps 1..3 shouldBeEqual false
        }
        it("full overlap") {
            isFullOverlap(2..4 to 3..3) shouldBeEqual true
            isFullOverlap(1..8 to 3..8) shouldBeEqual true
            isFullOverlap(2..4 to 3..5) shouldBeEqual false
            isFullOverlap(2..2 to 3..5) shouldBeEqual false
        }
        it("full overlap, test input") {
            solvePartOneTestInput() shouldBeEqual 2
        }
        it("full overlap, real input") {
            solvePartOneRealInput() shouldBeEqual 657
        }
    }
    context("part two") {
        it("test input") {
            solvePartTwoTestInput() shouldBeEqual 4
        }

        it("real input") {
            solvePartTwoRealInput() shouldBeEqual 938
        }
    }
})
