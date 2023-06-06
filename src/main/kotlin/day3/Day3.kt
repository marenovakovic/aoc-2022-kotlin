package day3

val String.compartments
    get() = substring(0, length / 2) to substring(length / 2)

val Char.priority
    get() = if (this.isLowerCase()) this.code - 96 else (this.code - 65 + 27)

val List<Char>.priority
    get() = sumOf { it.priority }

val Pair<String, String>.commonItems
    get() = first.toSet().intersect(second.toSet()).toList()
