package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay06 {
    private val inputData = javaClass.getResource("/examples/day06.txt")?.readText() ?: ""
    private val day = Day06()

    @Test
    fun testDay06RunA() {
        val output = day.runA(inputData)
        assertEquals(TODO(), output)
    }

    @Test
    fun testDay06RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }

}