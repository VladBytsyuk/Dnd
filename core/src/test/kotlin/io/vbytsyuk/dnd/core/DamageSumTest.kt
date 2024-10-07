package io.vbytsyuk.dnd.core

import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.units.Damage.Type.BLUDGEONING
import io.vbytsyuk.dnd.core.units.Damage.Type.LIGHTNING
import io.vbytsyuk.dnd.core.units.Damage.Type.PIERCING
import io.vbytsyuk.dnd.core.units.d12
import io.vbytsyuk.dnd.core.units.d4
import io.vbytsyuk.dnd.core.units.d6
import io.vbytsyuk.dnd.core.units.damage
import io.vbytsyuk.dnd.core.units.plus
import org.junit.jupiter.api.Test

class DamageSumTest : T<List<Damage>, Damage> {

    @Test
    fun `test Damage addition`() = check()

    override val dataSet = listOf(
        T.Data(
            name = "1d4 piercing + 3d4 piercing SHOULD BE 4d4 piercing",
            input = listOf(1.d4(PIERCING), 3.d4(PIERCING)),
            output = 4.d4(PIERCING)
        ),
        T.Data(
            name = "1d4 piercing + 4d6 lightning SHOULD BE 1d4 piercing + 4d6 light",
            input = listOf(1.d4(PIERCING), 4.d6(LIGHTNING)),
            output = Damage(
                entries = listOf(
                    Damage.Entry(type = PIERCING, dices = listOf(Damage.Dices(amount = 1, dice = Dice.D4))),
                    Damage.Entry(type = LIGHTNING, dices = listOf(Damage.Dices(amount = 4, dice = Dice.D6))),
                ),
            )
        ),
        T.Data(
            name = "complex case",
            input = listOf(
                1.d4(BLUDGEONING),
                4.d6(LIGHTNING),
                6.d4(PIERCING),
                1.d12(LIGHTNING),
                2.d4(BLUDGEONING),
                5.damage(LIGHTNING),
                6.d6(BLUDGEONING),
            ),
            output = Damage(
                entries = listOf(
                    Damage.Entry(
                        type = BLUDGEONING,
                        dices = listOf(
                            Damage.Dices(amount = 6, dice = Dice.D6),
                            Damage.Dices(amount = 3, dice = Dice.D4),
                        ),
                    ),
                    Damage.Entry(
                        type = LIGHTNING,
                        dices = listOf(
                            Damage.Dices(amount = 1, dice = Dice.D12),
                            Damage.Dices(amount = 4, dice = Dice.D6),
                            Damage.Dices(amount = 5, dice = Dice.D1),
                        ),
                    ),
                    Damage.Entry(
                        type = PIERCING,
                        dices = listOf(
                            Damage.Dices(amount = 6, dice = Dice.D4),
                        ),
                    ),
                ),
            )
        ),
        T.Data(
            name = "complex case",
            input = listOf(
                1.d4(BLUDGEONING),
                4.d6(LIGHTNING),
                6.d4(PIERCING),
                1.d12(LIGHTNING),
                2.d4(BLUDGEONING),
                5.damage(LIGHTNING),
                6.d6(BLUDGEONING),
            ),
            output = (6.d6 + 3.d4).damage(BLUDGEONING) + (1.d12 + 4.d6 + 5).damage(LIGHTNING) + 6.d4(PIERCING)
        ),
    )

    override fun act(input: List<Damage>): Damage = input.reduce { acc, damage -> acc + damage }
}
