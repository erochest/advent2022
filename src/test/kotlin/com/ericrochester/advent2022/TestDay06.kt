package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay06 {
    private val inputData = javaClass.getResource("/examples/day06.txt")?.readText() ?: ""
    private val day = Day06()

    @Test
    fun testDay06RunA() {
        val output = day.runA(inputData)
        assertEquals(7, output)

        assertEquals(5, day.runA("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, day.runA("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, day.runA("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, day.runA("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun testDay06RunB() {
        val output = day.runB(inputData)
        assertEquals(TODO(), output)
    }

}