package `2025`

import fromDigits
import println
import readInput
import toDigits

fun maxJoltageAux(bank: List<Long>, length: Int) : List<Long> {
    if (length == 1) return listOf(bank.max())

    val best = bank.dropLast(length - 1).max()
    val bestIdx = bank.indexOf(best)

    return listOf(best) + maxJoltageAux(bank.drop(bestIdx + 1), length - 1)
}

fun maxJoltage(bank: List<Long>, activate: Int = 2) : Long = maxJoltageAux(bank, activate).fromDigits()

fun main() {
    fun part1(input: List<String>): Long {
        return input.sumOf { maxJoltage(it.toDigits().map{j -> j.toLong()}) }
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { maxJoltage(it.toDigits().map { j -> j.toLong()}, activate = 12) }
    }

    val testInput = readInput(3, 2025, true)
    check(part1(testInput) == 357.toLong())
    check(part2(testInput) == 3121910778619)

    val input = readInput(3, 2025)
    part1(input).println()
    part2(input).println()
}
