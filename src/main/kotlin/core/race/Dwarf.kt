package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Dwarf(bonusStatBlock: StatBlock) : Race(bonusStatBlock) {
    data object Mountain : Dwarf(bonusStatBlock = StatBlock(strength = 2, constitution = 2))
    data object Hill : Dwarf(bonusStatBlock = StatBlock(constitution = 2, wisdom = 1))
}
