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
    }
})
