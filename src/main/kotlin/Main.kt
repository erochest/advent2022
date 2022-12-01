import com.ericrochester.advent2022.Day01
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option

class Advent2022: CliktCommand() {
    val test by option("--test", "-t").flag()
    val day by option("--day", "-d")

    override fun run() {
        val resourceName = if (test) {
            "/examples/day01.txt"
        } else {
            "/data/day01.txt"
        }

        val inputData =  ResourceReader.readResource(resourceName)
        val day01 = Day01()
        val output = if (day?.endsWith('a', true) != false) {
            day01.runA(inputData)
        } else {
            day01.runB(inputData)
        }
        println(output)
    }
}

fun main(args: Array<String>) = Advent2022().main(args)

private class ResourceReader {
    companion object {
        fun readResource(name: String): String {
            return ResourceReader::class.java.getResource(name)?.readText() ?: ""
        }
    }
}