package com.ericrochester.advent2022

class Day06: DayRuns<Int, Int> {
    override fun runA(inputData: String): Int {
        val first = inputData
            .withIndex()
            .windowed(4)
            .first { chunk ->
                chunk.map { it.value }.toSet().size == 4
            }
        return first.last().index + 1
    }

    override fun runB(inputData: String): Int {
        TODO("Not yet implemented")
    }

}
