package io.vbytsyuk.dnd.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StatsTest {

    @Test
    fun `modifier calculation`() {
        val table = mapOf(
            0 to Modifier(-5),
            1 to Modifier(-5),
            2 to Modifier(-4),
            3 to Modifier(-4),
            4 to Modifier(-3),
            5 to Modifier(-3),
            6 to Modifier(-2),
            7 to Modifier(-2),
            8 to Modifier(-1),
            9 to Modifier(-1),
            10 to Modifier(0),
            11 to Modifier(0),
            12 to Modifier(1),
            13 to Modifier(1),
            14 to Modifier(2),
            15 to Modifier(2),
            16 to Modifier(3),
            17 to Modifier(3),
            18 to Modifier(4),
            19 to Modifier(4),
            20 to Modifier(5),
            21 to Modifier(5),
            22 to Modifier(6),
            23 to Modifier(6),
            24 to Modifier(7),
            25 to Modifier(7),
            26 to Modifier(8),
            27 to Modifier(8),
            28 to Modifier(9),
            29 to Modifier(9),
            30 to Modifier(10),
        )
        table.forEach { (statValue, expectedModifier) ->
            testStat(Stat.Strength(statValue), expectedModifier)
            testStat(Stat.Dexterity(statValue), expectedModifier)
            testStat(Stat.Constitution(statValue), expectedModifier)
            testStat(Stat.Intelligence(statValue), expectedModifier)
            testStat(Stat.Wisdom(statValue), expectedModifier)
            testStat(Stat.Charisma(statValue), expectedModifier)
        }
    }


    private fun testStat(stat: Stat, expectedModifier: Modifier) {
        val actualModifier = stat.modifier
        assertEquals(
            expected = expectedModifier,
            actual = actualModifier,
            message = "Expected modifier for $stat is $expectedModifier but was $actualModifier",
        )
    }
}