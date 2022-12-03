package com.ericrochester.advent2022

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestDay03 {
    private val inputData = javaClass.getResource("/examples/day03.txt").readText()
    private val day03 = Day03()

    @Test
    fun testDay03RunA() {
        val output = day03.runA(inputData)
        assertEquals(157, output)
    }

    @Test
    fun testParseRuckSackA() {
        val left = "vJrwpWtwJgWr".toSet()
        val right = "hcsFMMfFFhFp".toSet()
        val ruckSack = Pair(left, right)
        assertEquals(ruckSack, day03.parseRuckSackA("vJrwpWtwJgWrhcsFMMfFFhFp"))
    }

    @Test
    fun testItemPriority() {
        // 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s)
        assertEquals(16, day03.itemPriority('p'))
        assertEquals(38, day03.itemPriority('L'))
    }
}