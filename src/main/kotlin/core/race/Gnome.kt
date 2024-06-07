package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Language.COMMON
import io.vbytsyuk.dnd.core.units.Language.GNOMISH
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Gnome(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.SMALL,
    baseSpeed = Speed(25.feet),
    darkVision = 60.feet,
    proficiencies = Proficiencies(
        languages = { it in listOf(COMMON, GNOMISH) },
    ),
) {
    data object Forest : Gnome(bonusStatBlock = StatBlock(intelligence = 2, dexterity = 1))
    data object Rock : Gnome(bonusStatBlock = StatBlock(intelligence = 2, constitution = 1))
}
