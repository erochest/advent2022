package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay08 {
    private val inputData = javaClass.getResource("/examples/day08.txt")?.readText() ?: ""
    private val day = Day08()

    @Test
    fun testDay08RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Test
    fun testDay08RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }

}