package com.ericrochester.advent2022

class Day01 {
    fun runA(inputData: String): Int {
        val maxCalorieSums = paragraphs(inputData.lines()).map {
            val sum = it.sumOf { line: String -> line.toInt() }
            println(sum)
            sum
        }.sortedDescending<Int>()
        println(maxCalorieSums)
        return maxCalorieSums.first()
    }

    fun runB(inputData: String): Int {
        var lines = inputData.lines()
        return 0
    }

    fun paragraphs(lines: List<String>): List<List<String>> {
        var lines = lines
        var output = emptyList<List<String>>().toMutableList()
        while (lines.isNotEmpty()) {
            val chunk = lines.takeWhile { it.isNotEmpty() }
            lines = lines.drop(chunk.size)
            output.add(chunk)
            lines = lines.drop(lines.takeWhile { it.isEmpty() }.size)
        }
        return output
    }

}
