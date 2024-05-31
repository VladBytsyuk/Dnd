package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Elf(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.MEDIUM,
    baseSpeed = Speed(30.feet),
) {
    data object High : Elf(bonusStatBlock = StatBlock(dexterity = 2, intelligence = 1))
    data object Wood : Elf(bonusStatBlock = StatBlock(dexterity = 2, wisdom = 1))
    data object Drow : Elf(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
