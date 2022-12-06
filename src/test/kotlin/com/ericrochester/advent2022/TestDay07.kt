package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay07 {
    private val inputData = javaClass.getResource("/examples/day07.txt")?.readText() ?: ""
    private val day = Day07()

    @Test
    fun testDay07RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Test
    fun testDay07RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }
}