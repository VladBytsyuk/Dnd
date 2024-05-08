package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Elf(bonusStatBlock: StatBlock) : Race(bonusStatBlock) {
    data object High : Elf(bonusStatBlock = StatBlock(dexterity = 2, intelligence = 1))
    data object Wood : Elf(bonusStatBlock = StatBlock(dexterity = 2, wisdom = 1))
    data object Drow : Elf(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
