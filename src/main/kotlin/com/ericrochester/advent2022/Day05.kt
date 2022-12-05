package com.ericrochester.advent2022

class Day05: DayRuns<String, Int> {
    override fun runA(inputData: String): String {
        var lines = inputData.lines()
        val stacks = parseStacks(lines.takeWhile { it.isNotBlank() })
        val stackMoves = lines
            .takeLastWhile { it.isNotBlank() }
            .map { parseStackMove(it) }
            .forEach {
//                println("MOVE ${it} -> ${stacks}")
                stacks.makeStackMove(it)
            }

        return stacks.peekAll().joinToString("")
    }

    override fun runB(inputData: String): Int {
        TODO("Not yet implemented")
    }

    fun parseStacks(input: List<String>): ElfStacks {
        val lastLine = input.last()
        val stackHeaders = lastLine.split("\\s+".toRegex()).filter { it.isNotBlank() }
//        println("headers = ${stackHeaders}")
        val stacks = Array(stackHeaders.size) { ArrayDeque<Char>() }

        input.dropLast(1)
            .forEach { line: String ->
                line.chunked(4)
                    .forEachIndexed { index, s ->
                        if (s.isNotBlank()) {
                            val c = s[1]
                            stacks[index].add(0, c)
                        }
                    }
            }

        return ElfStacks.withStacks(*stacks)
    }

    fun parseStackMove(input: String): StackMove {
        val parts = input.split("\\s+".toRegex())
        return StackMove(
            parts[1].toInt(),
            parts[3].toInt(),
            parts[5].toInt()
        )
    }
}

class ElfStacks {
    var stacks: List<ArrayDeque<Char>> = emptyList()

    companion object {
        fun withStacks(vararg stacks: ArrayDeque<Char>): ElfStacks {
            val elfStacks = ElfStacks()
            elfStacks.stacks = stacks.toList()
            return elfStacks
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ElfStacks

        if (stacks != other.stacks) return false

        return true
    }

    override fun hashCode(): Int {
        return stacks.hashCode()
    }

    override fun toString(): String {
        return "ElfStacks(stacks=$stacks)"
    }

    fun peekAll(): List<Char> = stacks.map { it.last() }
    fun makeStackMove(move: StackMove): Unit {
        repeat(move.n) {
            val item = stacks[move.from - 1].removeLast()
            stacks[move.to - 1].addLast(item)
        }
    }
}

data class StackMove(val n: Int, val from: Int, val to: Int)