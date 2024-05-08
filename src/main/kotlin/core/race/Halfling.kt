package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Halfling(bonusStatBlock: StatBlock) : Race(bonusStatBlock) {
    data object Stout : Halfling(bonusStatBlock = StatBlock(dexterity = 2, constitution = 1))
    data object Lightfoot : Halfling(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
