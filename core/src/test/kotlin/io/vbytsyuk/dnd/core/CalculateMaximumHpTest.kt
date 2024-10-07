package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.units.Hp
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.core.units.calculateMaximumHp
import org.junit.jupiter.api.Test

class CalculateMaximumHpTest : T<CalculateMaximumHpTest.Input, Hp> {

    data class Input(
        val hpBase: Hp,
        val hpIncrement: Hp,
        val constitutionModifier: Modifier,
        val level: Level,
    )

    override val dataSet = listOf(
        T.Data(
            name = "Fighter (1) with con (14) should have 12 hp",
            input = Input(
                hpBase = Hp(10), hpIncrement = Hp(6), constitutionModifier = Modifier(2), level = Level(1),
            ),
            output = Hp(12),
        ),
        T.Data(
            name = "Fighter (5) with con (16) should have 67 hp",
            input = Input(
                hpBase = Hp(10), hpIncrement = Hp(6), constitutionModifier = Modifier(3), level = Level(5),
            ),
            output = Hp(67),
        ),
        T.Data(
            name = "Fighter (10) with con (16) should have 202 hp",
            input = Input(
                hpBase = Hp(10), hpIncrement = Hp(6), constitutionModifier = Modifier(3), level = Level(10),
            ),
            output = Hp(202),
        ),
        T.Data(
            name = "Fighter (15) with con (18) should have 518 hp",
            input = Input(
                hpBase = Hp(10), hpIncrement = Hp(6), constitutionModifier = Modifier(4), level = Level(15),
            ),
            output = Hp(518),
        ),
        T.Data(
            name = "Fighter (20) with con (20) should have 1079 hp",
            input = Input(
                hpBase = Hp(10), hpIncrement = Hp(6), constitutionModifier = Modifier(5), level = Level(20),
            ),
            output = Hp(1079),
        ),
    )

    override fun act(input: Input): Hp = calculateMaximumHp(
        hpBase = input.hpBase,
        hpIncrement = input.hpIncrement,
        constitutionModifier = input.constitutionModifier,
        level = input.level,
        traits = emptyList(),
    )

    @Test
    fun `test calculateMaximumHp function`() = check()
}
