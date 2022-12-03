package com.ericrochester.advent2022

class Day03 : DayRuns {
    override fun runA(inputData: String): Int {
        return inputData.lines()
            .sumOf { line: String ->
                val ruckSackA = parseRuckSackA(line)
                val common = ruckSackA.first.intersect(ruckSackA.second)
                common.sumOf { itemPriority(it) }
            }
    }

    override fun runB(inputData: String): Int {
        TODO("Not yet implemented")
    }

    fun parseRuckSackA(line: String): RuckSackA {
        val midpoint = line.length / 2
        val first = line.subSequence(0, midpoint).toSet()
        val second = line.subSequence(midpoint, line.length).toSet()
        return Pair(first, second)
    }

    fun itemPriority(item: Char): Int {
        return if (item.isLowerCase())
            (item.code - 'a'.code) + 1
        else
            (item.code - 'A'.code) + 27
    }

}

typealias RuckSackA = Pair<Set<Char>, Set<Char>>