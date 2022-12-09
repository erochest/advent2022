package com.ericrochester.advent2022

import kotlin.math.abs
import kotlin.math.sign

class Day09: DayRuns<Int, Int> {
    override fun runA(inputData: String): Int =
        inputData.lines()
            .map { DirectionPair.parse(it) }
            .fold(Board(Pair(0, 0), Pair(0, 0))) { board, dirPair ->
                board.move(dirPair)
                board
            }
            .tailTrack
            .size

    override fun runB(inputData: String): Int {
        TODO("Not yet implemented")
    }


}

data class DirectionPair(val direction: Direction, val distance: Int) {
    companion object {
        fun parse(input: String): DirectionPair {
            val parts = input.split(" ")
            val dir = when (parts[0]) {
                "R"  -> Direction.Right
                "L"  -> Direction.Left
                "U"  -> Direction.Up
                else -> Direction.Down
            }
            val dist = parts[1].toInt()
            return DirectionPair(dir, dist)
        }
    }
}

enum class Direction {
    Right,
    Left,
    Up,
    Down
}

data class Board(var head: Pair<Int, Int>, var tail: Pair<Int, Int>) {
    val tailTrack = mutableSetOf<Pair<Int, Int>>()

    init {
        tailTrack.add(tail)
    }

    fun move(direction: Direction) {
        head = when (direction) {
            Direction.Right -> head.copy(first=head.first+1)
            Direction.Left -> head.copy(first=head.first-1)
            Direction.Up -> head.copy(second=head.second+1)
            Direction.Down -> head.copy(second=head.second-1)
        }

        if (abs(head.first - tail.first) > 1 || abs(head.second - tail.second) > 1) {
            tail = if (head.first == tail.first) {
                tail.copy(second=tail.second+(head.second-tail.second).sign)
            } else if (head.second == tail.second) {
                tail.copy(first=tail.first+(head.first-tail.first).sign)
            } else {
                Pair(
                    tail.first+(head.first-tail.first).sign,
                    tail.second+(head.second-tail.second).sign
                )
            }
            tailTrack.add(tail)
        }
    }

    fun move(directionPair: DirectionPair) {
        repeat(directionPair.distance) {
            move(directionPair.direction)
        }
    }

}
