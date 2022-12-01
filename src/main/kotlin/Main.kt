import com.ericrochester.advent2022.Day01

fun main(args: Array<String>) {
    val test = args.contains("--test")
    val resourceName = if (test) {
        "/examples/day01.txt"
    } else {
        "/data/day01.txt"
    }

    val inputData =  ResourceReader.readResource(resourceName)
    val day01 = Day01()
    val output = day01.runA(inputData)
    println(output)
}

private class ResourceReader {
    companion object {
        fun readResource(name: String): String {
            return javaClass.getResource(name).readText()
        }
    }
}