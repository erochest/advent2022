package com.ericrochester.advent2022

class Day10: DayRuns<Int,Int> {
    override fun runA(inputData: String): Int {
        val history = execute(inputData.lines())
        return (20..(history.size) step 40)
            .sumOf { signalStrength(history, it) }
    }

    override fun runB(inputData: String): Int {
        TODO("Not yet implemented")
    }

}

data class Cpu(var register: Int) {
    val history: MutableList<Int> = mutableListOf()

    val output: List<Int>
        get() {
            val output = mutableListOf<Int>()
            output.addAll(history)
            output.add(register)
            return output.toList()
        }

    fun noop() {
        history.add(register)
    }

    fun addx(x: Int) {
        history.add(register)
        history.add(register)
        register += x
    }
}

fun execute(commands: List<String>): List<Int> {
    return commands.fold(Cpu(1)) { cpu, command ->
        if (command == "noop") {
            cpu.noop()
        } else {
            val parts = command.split(' ')
            val value = parts[1].toInt()
            cpu.addx(value)
        }
        cpu
    }.output
}

fun signalStrength(cpuOutput: List<Int>, cycle: Int): Int {
    return cycle * cpuOutput[cycle - 1]
}
