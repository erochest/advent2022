import kotlin.test.Test
import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import kotlin.test.assertEquals

class TestMain {
    @Test
    fun testMainRunsWithoutException() {
        main(emptyArray())
    }

    @Test
    fun testDay01ARuns() {
        val systemOut = tapSystemOut {
            main(arrayListOf("--test", "--day", "01A").toTypedArray())
        }
        assertEquals("24000", systemOut.trim())
    }
}