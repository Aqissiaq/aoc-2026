package `2025`

import println
import readInput

fun String.splitAtIndex(index : Int) = take(index) to substring(index)
fun parseMove (input: String): Pair<String, Int> {
    val (dir, n) = input.splitAtIndex(1)
    return dir to n.toInt()
}
fun fits(x: Int) = if (x % 100 == 0) 1 else 0
fun zeroesBetween(x: Int, y:Int ) = y.floorDiv(100) - x.floorDiv(100) + fits(x)
fun main() {
    fun part1(input: List<String>): Int {
        var pos = 50
        var counter = 0
        for ((dir, n) in input.map { parseMove(it) }) {
            when (dir) {
                "L" -> pos -= n
                "R" -> pos += n
            }
            pos %= 100
            if (pos == 0) { counter++ }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var pos = 50
        var counter = 0
        for ((dir, n) in input.map { parseMove(it) }) {
            when (dir) {
                "L" -> {
                    val newPos = pos - n
                    counter += zeroesBetween(newPos, pos)
                    pos = newPos
                }
                "R" -> {
                    val newPos = pos + n
                    counter += zeroesBetween(pos, newPos)
                    pos = newPos
                }
            }
            println("pos=$pos, counter=$counter")
        }
        return counter - part1(input) // we double count the zeroes here, so lets just subtract the trivial ones
    }

    val testInput = readInput(1, 2025, true)
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    val input = readInput(1, 2025)
    part1(input).println()
    part2(input).println()
}
