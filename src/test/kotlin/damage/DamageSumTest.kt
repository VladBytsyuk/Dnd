package io.vbytsyuk.dnd.core.damage

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.T
import io.vbytsyuk.dnd.core.units.Damage
import io.vbytsyuk.dnd.core.units.Damage.Type.*
import io.vbytsyuk.dnd.core.units.d4
import io.vbytsyuk.dnd.core.units.d6
import org.junit.jupiter.api.Test

class DamageSumTest : T<Pair<Damage, Damage>, Damage> {

    @Test
    fun `test Damage addition`() = check()

    override val dataSet = listOf(
        T.Data(
            name = "1d4 piercing + 3d4 piercing SHOULD BE 4d4 piercing",
            input = 1.d4(PIERCING) to 3.d4(PIERCING),
            output = 4.d4(PIERCING)
        ),
        T.Data(
            name = "1d4 piercing + 4d6 lightning SHOULD BE 1d4 piercing + 4d6 light",
            input = 1.d4(PIERCING) to 4.d6(LIGHTNING),
            output = Damage(
                entries = listOf(
                    Damage.Entry(type = PIERCING, dices = listOf(Damage.Dices(amount = 1, dice = Dice.D4))),
                    Damage.Entry(type = LIGHTNING, dices = listOf(Damage.Dices(amount = 4, dice = Dice.D6))),
                ),
            )
        ),
    )

    override fun act(input: Pair<Damage, Damage>): Damage = input.first + input.second
}