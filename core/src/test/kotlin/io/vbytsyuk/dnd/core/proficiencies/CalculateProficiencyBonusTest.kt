package io.vbytsyuk.dnd.core.proficiencies

import io.vbytsyuk.dnd.core.Modifier
import io.vbytsyuk.dnd.core.units.Level
import io.vbytsyuk.dnd.test.T
import org.junit.jupiter.api.Test

class CalculateProficiencyBonusTest : T<Level, Modifier> {

    @Test
    fun `test calculateMaximumHp function`() = check()

    override val dataSet: Collection<T.Data<Level, Modifier>> = buildList {
        (1..20).forEach { value ->
            val level = Level(value)
            this += T.Data(name = level.toString(), input = level, output = calculateCanonicalProficiencyBonus(level))
        }
    }

    override fun act(input: Level): Modifier = calculateProficiencyBonus(input)
}
