package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.length.feet
import io.vbytsyuk.dnd.core.sizie.Size

sealed class Gnome(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.SMALL,
    baseSpeed = Speed(25.feet),
) {
    data object Forest : Gnome(bonusStatBlock = StatBlock(intelligence = 2, dexterity = 1))
    data object Rock : Gnome(bonusStatBlock = StatBlock(intelligence = 2, constitution = 1))
}