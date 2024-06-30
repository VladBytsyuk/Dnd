package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Language.COMMON
import io.vbytsyuk.dnd.core.units.Language.HALFLING
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Halfling(
    override val bonusStatBlock: StatBlock,
) : Race {

    override val size = Size.SMALL
    override val baseSpeed = Speed(25.feet)
    override val darkVision = null
    override val proficiencies = Proficiencies(
        languages = { it in listOf(COMMON, HALFLING) },
    )

    data object Stout : Halfling(bonusStatBlock = StatBlock(dexterity = 2, constitution = 1))
    data object Lightfoot : Halfling(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
