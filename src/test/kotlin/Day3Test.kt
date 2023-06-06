import day3.commonItems
import day3.compartments
import day3.priority
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

class Day3Test : DescribeSpec({
    context("rucksacks") {
        it("split line into compartments") {
            "aa".compartments shouldBeEqual ("a" to "a")
            "bb".compartments shouldBeEqual ("b" to "b")
        }
        it("item priority") {
            'a'.priority shouldBeEqual 1
            'b'.priority shouldBeEqual 2
            'z'.priority shouldBeEqual 26
            'A'.priority shouldBeEqual 27
            'B'.priority shouldBeEqual 28
            'Z'.priority shouldBeEqual 52
        }
        it("find common items") {
            ("ab" to "ac").commonItems shouldBeEqual listOf('a')
            ("ab" to "ab").commonItems shouldBeEqual listOf('a', 'b')
        }
        it("compartment priority") {
            listOf('a', 'a').priority shouldBeEqual 2
            listOf('a', 'b').priority shouldBeEqual 3
            listOf('b', 'b').priority shouldBeEqual 4
            listOf('a', 'Z').priority shouldBeEqual 53
        }
        it("part one, test input") {
            readInput("day3/test_input.txt")
                .lines()
                .map { it.compartments }
                .map { it.commonItems }
                .sumOf { it.priority }
                .shouldBeEqual(157)
        }
        it("part one, real input") {
            readInput("day3/input.txt")
                .lines()
                .map { it.compartments }
                .map { it.commonItems }
                .sumOf { it.priority }
                .shouldBeEqual(8185)
        }
    }
})
