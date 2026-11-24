package `2025`

import println
import readInput

fun getRange(input: String) : Pair<Long, Long> {
    val (l, r) = input.split("-")
    return l.toLong() to r.toLong()
}
fun valid(n: Long) : Boolean {
    val length = n.toString().length
    if (length % 2 != 0) return true
    val (l, r) = n.toString().chunked(length / 2)
    return (l != r)
}
fun <T> Iterable<T>.allEqual() = distinct().size == 1
fun valid2(n: Long) : Boolean {
    val length = n.toString().length
    for (i in length / 2 downTo 1) {
        if (n.toString().chunked(i).allEqual()) { return false }
    }
    return true
}

fun main() {
    fun part1(input: List<String>): Long {
        var count : Long = 0
        for ((l,r) in input.map {getRange(it)}) {
            count += (l..r).filter {!valid(it)}.sum()
        }
        return count
    }

    fun part2(input: List<String>): Long {
        var count : Long = 0
        for ((l,r) in input.map {getRange(it)}) {
            count += (l..r).filter {!valid2(it)}.sum()
        }
        return count
    }

    val testInput = readInput(2, 2025, true).first().split(",")
    check(part1(testInput) == 1227775554.toLong())
    //check(part2(testInput) == 6)

    val input = readInput(2, 2025).first().split(",")
    part1(input).println()
    part2(input).println()
}
