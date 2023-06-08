import day4.isFullOverlap
import day4.overlaps
import day4.testLines
import day4.toPairAssignment
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

class Day4Test : DescribeSpec({
    context("section") {
        it("can parse assignment") {
            "2-4,6-8".toPairAssignment() shouldBeEqual (2..4 to 6..8)
            "1-3,5-7".toPairAssignment() shouldBeEqual (1..3 to 5..7)
            "8-9,9-9".toPairAssignment() shouldBeEqual (8..9 to 9..9)
        }
        it("overlap") {
            overlaps(2..4, 2..3) shouldBeEqual true
            overlaps(3..3, 2..8) shouldBeEqual true
            overlaps(2..4, 3..5) shouldBeEqual true
            overlaps(2..4, 5..7) shouldBeEqual false
            overlaps(5..7, 1..3) shouldBeEqual false
        }
        it("full overlap") {
            isFullOverlap(2..4 to 3..3) shouldBeEqual true
            isFullOverlap(1..8 to 3..8) shouldBeEqual true
            isFullOverlap(2..4 to 3..5) shouldBeEqual false
            isFullOverlap(2..2 to 3..5) shouldBeEqual false
        }
        it("full overlap, test input") {
            testLines()
                .map { it.toPairAssignment() }
                .count(::isFullOverlap) shouldBeEqual 2
        }
    }
})
