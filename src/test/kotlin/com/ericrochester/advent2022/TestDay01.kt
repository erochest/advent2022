package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay01 {
    @Test
    fun testRunA() {
        val inputData = javaClass.getResource("/examples/day01.txt").readText()
        val day01 = Day01()
        val output = day01.runA(inputData)
        assertEquals(24000, output)
    }
}