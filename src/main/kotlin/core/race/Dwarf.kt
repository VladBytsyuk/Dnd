package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Dwarf(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.MEDIUM,
    baseSpeed = Speed(25.feet),
) {
    data object Mountain : Dwarf(bonusStatBlock = StatBlock(strength = 2, constitution = 2))
    data object Hill : Dwarf(bonusStatBlock = StatBlock(constitution = 2, wisdom = 1))
}
