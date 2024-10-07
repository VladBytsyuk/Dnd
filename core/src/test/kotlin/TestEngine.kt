import kotlin.test.assertTrue

interface T<I, O> {
    data class Data<I, O>(
        val name: String,
        val input: I,
        val output: O,
    )

    val dataSet: Collection<Data<I, O>>

    fun act(input: I): O

    fun check() {
        val errors = dataSet.mapNotNull { (name, input, output) ->
            val actual = act(input)
            if (actual != output) "Test '$name' failed. Expected $output but was $actual" else null
        }.joinToString(separator = "\n", prefix = "", postfix = "")
        assertTrue(errors.isEmpty(), message = errors)
    }
}
