package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Gnome(bonusStatBlock: StatBlock) : Race(bonusStatBlock) {
    data object Forest : Gnome(bonusStatBlock = StatBlock(intelligence = 2, dexterity = 1))
    data object Rock : Gnome(bonusStatBlock = StatBlock(intelligence = 2, constitution = 1))
}