import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.math.pow

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Int, year: Int = 26, test: Boolean = false) : List<String>  {
    val dir = if (year == 26) "" else "$year/"
    val suffix = if (test) "_test" else ""
    val name = "Day${day.toString().padStart(2, '0')}"
    return Path("data/$dir$name$suffix.txt").readText().trim().lines()
}
/**
 * Convert string of digits to list of digits, ignoring any non-digit characters
 */
fun String.toDigits() = mapNotNull { it.digitToIntOrNull() }

/**
 * Number formed by concatenation of digits
 */

fun List<Long>.fromDigits() : Long = this.fold(0L) { acc, digit -> acc * 10 + digit }

// integer exponentiation because we apparently can't have that
fun Int.pow(exp: Int) = this.toDouble().pow(exp).toInt()
/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
