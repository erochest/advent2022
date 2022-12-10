package com.ericrochester.advent2022

import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test

class TestDay11 {
    private val inputData = javaClass.getResource("/examples/day11.txt")?.readText() ?: ""
    private val day = Day11()

    @Ignore @Test fun testDay11RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Ignore @Test fun testDay11RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }
}