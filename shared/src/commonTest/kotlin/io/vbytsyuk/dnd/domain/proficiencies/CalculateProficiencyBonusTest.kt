package io.vbytsyuk.dnd.domain.proficiencies

import io.vbytsyuk.dnd.domain.Modifier
import io.vbytsyuk.dnd.domain.units.Level
import io.vbytsyuk.dnd.test.T
import kotlin.test.Test

class CalculateProficiencyBonusTest : T<Level, Modifier> {

    @Test
    fun test_calculateProficiencyBonus_function() = check()

    override val dataSet: Collection<T.Data<Level, Modifier>> = buildList {
        (1..20).forEach { value ->
            val level = Level(value)
            this += T.Data(name = level.toString(), input = level, output = calculateCanonicalProficiencyBonus(level))
        }
    }

    override fun act(input: Level): Modifier = calculateProficiencyBonus(input)
}
