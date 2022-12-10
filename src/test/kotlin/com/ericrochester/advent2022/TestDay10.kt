package com.ericrochester.advent2022

import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay10 {
    private val inputData = javaClass.getResource("/examples/day10.txt")?.readText() ?: ""
    private val day = Day10()

    @Test fun testDay10RunA() {
        val output = day.runA(inputData)
        assertEquals(13140, output)
    }

    @Ignore @Test fun testDay10RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }

    @Test fun testExecuteStartsWithEmptyList() {
        val output = execute(listOf())
        assertEquals(listOf(1), output)
    }

    @Test fun testExecuteNoopDoesNothingForASecond() {
        val output = execute(listOf("noop"))
        assertEquals(listOf(1, 1), output)
    }

    @Test fun testExecuteAddX() {
        val output = execute(listOf("addx 3"))
        assertEquals(listOf(1, 1, 4), output)
    }

    @Test fun testExecuteProgram() {
        val input = listOf("noop", "addx 3", "addx -5")
        val output = execute(input)
        val expected = listOf(1, 1, 1, 4, 4, -1)
        assertEquals(expected, output)
    }

    @Test fun cpuNoop() {
        val cpu = Cpu(1)
        cpu.noop()
        assertEquals(1, cpu.register)
        assertEquals(listOf(1), cpu.history)
    }

    @Test fun cpuAddX() {
        val cpu = Cpu(1)
        cpu.addx(3)
        assertEquals(4, cpu.register)
        assertEquals(listOf(1, 1), cpu.history)
    }

    @Test fun signalStrength() {
        val cpuOutput = listOf(1, 1, 1, 4, 4, -1)
        assertEquals(16, signalStrength(cpuOutput, 4))
        assertEquals(20, signalStrength(cpuOutput, 5))
        assertEquals(-6, signalStrength(cpuOutput, 6))
    }
}