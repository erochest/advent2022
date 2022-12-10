package com.ericrochester.advent2022

import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay10 {
    private val inputData = javaClass.getResource("/examples/day10.txt")?.readText() ?: ""
    private val day = Day10()

    @Ignore @Test fun testDay10RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Ignore @Test fun testDay10RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }
}