package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay05 {
    private val inputData = javaClass.getResource("/examples/day05.txt")?.readText() ?: ""
    private val day = Day05()

    @Test
    fun testDay05RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Test
    fun testDay05RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }
}