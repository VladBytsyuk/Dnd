package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.units.Distance
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Elf(
    bonusStatBlock: StatBlock,
    baseSpeed: Speed? = null,
    darkVision: Distance? = null,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.MEDIUM,
    baseSpeed = baseSpeed ?: Speed(30.feet),
    darkVision = darkVision ?: 60.feet,
) {
    data object High : Elf(bonusStatBlock = StatBlock(dexterity = 2, intelligence = 1))
    data object Wood : Elf(bonusStatBlock = StatBlock(dexterity = 2, wisdom = 1), baseSpeed = Speed(35.feet))
    data object Drow : Elf(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1), darkVision = 120.feet)
}
