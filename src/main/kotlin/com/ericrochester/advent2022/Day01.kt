package com.ericrochester.advent2022

class Day01 {
    fun runA(inputData: String): Int {
        var lines = inputData.lines()
        var maxCalorieSum = 0
        while (!lines.isEmpty()) {
            val chunk = lines.takeWhile { it.isNotEmpty() }
            lines = lines.drop(chunk.size)
            val chunkSum = chunk.map { it.toInt() }.sum()
            maxCalorieSum = maxOf(maxCalorieSum, chunkSum)
            lines = lines.drop(lines.takeWhile { it.isEmpty() }.size)
        }
        return maxCalorieSum
    }

}
