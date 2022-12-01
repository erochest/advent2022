package com.ericrochester.advent2022

class Day01 {
    fun runA(inputData: String): Int {
        val maxCalorieSums = paragraphs(inputData.lines()).map {
            it.sumOf { line: String -> line.toInt() }
        }.sortedDescending()
        return maxCalorieSums.first()
    }

    fun runB(inputData: String): Int {
        val maxCalorieSums = paragraphs(inputData.lines()).map {
            it.sumOf { line: String -> line.toInt() }
        }.sortedDescending()
        return maxCalorieSums.take(3).sum()
    }

    fun paragraphs(lines: List<String>): List<List<String>> {
        var buffer = lines
        val output = emptyList<List<String>>().toMutableList()
        while (buffer.isNotEmpty()) {
            val chunk = buffer.takeWhile { it.isNotEmpty() }
            buffer = buffer.drop(chunk.size)
            output.add(chunk)
            buffer = buffer.drop(buffer.takeWhile { it.isEmpty() }.size)
        }
        return output
    }

}
