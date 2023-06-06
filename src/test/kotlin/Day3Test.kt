import day3.Group
import day3.commonItems
import day3.compartments
import day3.priority
import day3.readRealInput
import day3.readTestInput
import day3.splitIntoGroups
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual

class Day3Test : DescribeSpec({
    context("rucksacks") {
        it("split line into compartments") {
            compartments("aa") shouldBeEqual ("a" to "a")
            compartments("bb") shouldBeEqual ("b" to "b")
        }
        it("item priority") {
            priority('a') shouldBeEqual 1
            priority('b') shouldBeEqual 2
            priority('z') shouldBeEqual 26
            priority('A') shouldBeEqual 27
            priority('B') shouldBeEqual 28
            priority('Z') shouldBeEqual 52
        }
        it("find common items") {
            commonItems(("ab" to "ac")) shouldBeEqual listOf('a')
            commonItems(("ab" to "ab")) shouldBeEqual listOf('a', 'b')
        }
        it("compartment priority") {
            priority(listOf('a', 'a')) shouldBeEqual 2
            priority(listOf('a', 'b')) shouldBeEqual 3
            priority(listOf('b', 'b')) shouldBeEqual 4
            priority(listOf('a', 'Z')) shouldBeEqual 53
        }
        it("part one, test input") {
            readTestInput()
                .map(::compartments)
                .map(::commonItems)
                .sumOf(::priority)
                .shouldBeEqual(157)
        }
        it("part one, real input") {
            readRealInput()
                .map(::compartments)
                .map(::commonItems)
                .sumOf(::priority)
                .shouldBeEqual(8185)
        }
    }
    context("group badge") {
        it("split into groups") {
            splitIntoGroups(listOf("a", "a", "a")) shouldBeEqual listOf(Group("a", "a", "a"))
            splitIntoGroups(listOf("a", "a", "a", "b", "b", "b"))
                .shouldBeEqual(
                    listOf(
                        Group("a", "a", "a"),
                        Group("b", "b", "b"),
                    )
                )
        }
    }
})
