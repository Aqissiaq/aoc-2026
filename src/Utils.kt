import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

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
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
