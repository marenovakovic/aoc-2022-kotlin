import day4.overlaps
import day4.parseSection
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

class Day4Test : DescribeSpec({
    context("section") {
        it("can parse assignment") {
            parseSection("2-4,6-8") shouldBeEqual (2..4 to 6..8)
            parseSection("1-3,5-7") shouldBeEqual (1..3 to 5..7)
            parseSection("8-9,9-9") shouldBeEqual (8..9 to 9..9)
        }
        it("overlap") {
            overlaps(2..4, 2..3) shouldBeEqual true
            overlaps(3..3, 2..8) shouldBeEqual true
            overlaps(2..4, 3..5) shouldBeEqual true
            overlaps(2..4, 5..7) shouldBeEqual false
            overlaps(5..7, 1..3) shouldBeEqual false
        }
    }
})
