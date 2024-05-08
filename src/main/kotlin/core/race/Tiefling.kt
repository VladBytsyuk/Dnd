package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.StatBlock

sealed class Tiefling(bonusStatBlock: StatBlock) : Race(bonusStatBlock) {
    data object Asmodeus : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Baalzebul : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Dispater : Tiefling(bonusStatBlock = StatBlock(charisma = 2, dexterity = 1))
    data object Fierna : Tiefling(bonusStatBlock = StatBlock(charisma = 2, wisdom = 1))
    data object Glasya : Tiefling(bonusStatBlock = StatBlock(charisma = 2, dexterity = 1))
    data object Levistus : Tiefling(bonusStatBlock = StatBlock(charisma = 2, constitution = 1))
    data object Mammon : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Mephistopheles : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Zariel : Tiefling(bonusStatBlock = StatBlock(charisma = 2, strength = 1))
}