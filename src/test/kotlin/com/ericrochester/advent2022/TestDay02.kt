package com.ericrochester.advent2022

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDay02 {
    private val inputData = javaClass.getResource("/examples/day02.txt").readText()
    private val day02 = Day02()

    @Test
    fun testDay02RunA() {
        val output = day02.runA(inputData)
        assertEquals(15, output)
    }

    @Test
    fun testRockPaperScissorsParse() {
        assertEquals(RockPaperScissors.ROCK, RockPaperScissors.parse('A'))
        assertEquals(RockPaperScissors.ROCK, RockPaperScissors.parse('X'))
        assertEquals(RockPaperScissors.PAPER, RockPaperScissors.parse('B'))
        assertEquals(RockPaperScissors.PAPER, RockPaperScissors.parse('Y'))
        assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.parse('C'))
        assertEquals(RockPaperScissors.SCISSORS, RockPaperScissors.parse('Z'))
    }

    @Test
    fun testGameScore() {
        assertEquals(8, GameScore.score(RockPaperScissors.ROCK, RockPaperScissors.PAPER))
        assertEquals(1, GameScore.score(RockPaperScissors.PAPER, RockPaperScissors.ROCK))
        assertEquals(6, GameScore.score(RockPaperScissors.SCISSORS, RockPaperScissors.SCISSORS))
        assertEquals(7, GameScore.score(RockPaperScissors.SCISSORS, RockPaperScissors.ROCK))
        assertEquals(9, GameScore.score(RockPaperScissors.PAPER, RockPaperScissors.SCISSORS))
    }
}