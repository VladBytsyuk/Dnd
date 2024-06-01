package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Halfling(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.SMALL,
    baseSpeed = Speed(25.feet),
    darkVision = null,
    proficiencies = Proficiencies(),
) {
    data object Stout : Halfling(bonusStatBlock = StatBlock(dexterity = 2, constitution = 1))
    data object Lightfoot : Halfling(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
