package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay09 {
    private val inputData = javaClass.getResource("/examples/day09.txt")?.readText() ?: ""
    private val day = Day09()

    @Test
    fun testDay09RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Test
    fun testDay09RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }

}