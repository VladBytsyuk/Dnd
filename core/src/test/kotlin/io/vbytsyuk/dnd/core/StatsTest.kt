package io.vbytsyuk.dnd.core

import org.junit.jupiter.api.Test

class StatsTest : T<Int, Modifier> {

    @Test
    fun `test modifier function`() = check()

    override val dataSet: Collection<T.Data<Int, Modifier>> = listOf(
        T.Data(name = "Stat value = 0", input = 0, output = Modifier(-5)),
        T.Data(name = "Stat value = 1", input = 1, output = Modifier(-5)),
        T.Data(name = "Stat value = 2", input = 2, output = Modifier(-4)),
        T.Data(name = "Stat value = 3", input = 3, output = Modifier(-4)),
        T.Data(name = "Stat value = 4", input = 4, output = Modifier(-3)),
        T.Data(name = "Stat value = 5", input = 5, output = Modifier(-3)),
        T.Data(name = "Stat value = 6", input = 6, output = Modifier(-2)),
        T.Data(name = "Stat value = 7", input = 7, output = Modifier(-2)),
        T.Data(name = "Stat value = 8", input = 8, output = Modifier(-1)),
        T.Data(name = "Stat value = 9", input = 9, output = Modifier(-1)),
        T.Data(name = "Stat value = 10", input = 10, output = Modifier(0)),
        T.Data(name = "Stat value = 11", input = 11, output = Modifier(0)),
        T.Data(name = "Stat value = 12", input = 12, output = Modifier(1)),
        T.Data(name = "Stat value = 13", input = 13, output = Modifier(1)),
        T.Data(name = "Stat value = 14", input = 14, output = Modifier(2)),
        T.Data(name = "Stat value = 15", input = 15, output = Modifier(2)),
        T.Data(name = "Stat value = 16", input = 16, output = Modifier(3)),
        T.Data(name = "Stat value = 17", input = 17, output = Modifier(3)),
        T.Data(name = "Stat value = 18", input = 18, output = Modifier(4)),
        T.Data(name = "Stat value = 19", input = 19, output = Modifier(4)),
        T.Data(name = "Stat value = 20", input = 20, output = Modifier(5)),
        T.Data(name = "Stat value = 21", input = 21, output = Modifier(5)),
        T.Data(name = "Stat value = 22", input = 22, output = Modifier(6)),
        T.Data(name = "Stat value = 23", input = 23, output = Modifier(6)),
        T.Data(name = "Stat value = 24", input = 24, output = Modifier(7)),
        T.Data(name = "Stat value = 25", input = 25, output = Modifier(7)),
        T.Data(name = "Stat value = 26", input = 26, output = Modifier(8)),
        T.Data(name = "Stat value = 27", input = 27, output = Modifier(8)),
        T.Data(name = "Stat value = 28", input = 28, output = Modifier(9)),
        T.Data(name = "Stat value = 29", input = 29, output = Modifier(9)),
        T.Data(name = "Stat value = 30", input = 30, output = Modifier(10)),
    )

    override fun act(input: Int): Modifier {
        val statBlock = StatBlock(strength = input)
        return statBlock.modifier(StatType.STR)
    }
}
