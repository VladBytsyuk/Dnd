package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Language.COMMON
import io.vbytsyuk.dnd.core.units.Language.DWARVISH
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size
import io.vbytsyuk.dnd.core.weapon.Battleaxe
import io.vbytsyuk.dnd.core.weapon.Handaxe
import io.vbytsyuk.dnd.core.weapon.LightHammer
import io.vbytsyuk.dnd.core.weapon.Warhammer

sealed class Dwarf(
    bonusStatBlock: StatBlock,
) : Race(
    bonusStatBlock = bonusStatBlock,
    size = Size.MEDIUM,
    baseSpeed = Speed(25.feet),
    darkVision = 60.feet,
    proficiencies = Proficiencies(
        weapons = { it in listOf(Battleaxe, Handaxe, LightHammer, Warhammer) },
        languages = { it in listOf(COMMON, DWARVISH) },
    ),
) {
    data object Mountain : Dwarf(bonusStatBlock = StatBlock(strength = 2, constitution = 2))
    data object Hill : Dwarf(bonusStatBlock = StatBlock(constitution = 2, wisdom = 1))
}
