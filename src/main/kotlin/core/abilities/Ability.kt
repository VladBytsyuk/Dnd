package io.vbytsyuk.dnd.core.abilities

import io.vbytsyuk.dnd.core.StatType

sealed class Ability(val originStatType: StatType) {

    sealed class Strength : Ability(originStatType = StatType.STR) {
        data object Athletics : Strength()
    }

    sealed class Dexterity : Ability(originStatType = StatType.DEX) {
        data object Acrobatics : Dexterity()
        data object SleightOfHand : Dexterity()
        data object Stealth : Dexterity()
    }

    sealed class Intelligence : Ability(originStatType = StatType.INT) {
        data object Arcana : Intelligence()
        data object History : Intelligence()
        data object Investigation : Intelligence()
        data object Nature : Intelligence()
        data object Religion : Intelligence()
    }

    sealed class Wisdom : Ability(originStatType = StatType.WIS) {
        data object AnimalHandling : Wisdom()
        data object Insight : Wisdom()
        data object Medicine : Wisdom()
        data object Perception : Wisdom()
        data object Survival : Wisdom()
    }

    sealed class Charisma : Ability(originStatType = StatType.CHA) {
        data object Deception : Charisma()
        data object Intimidation : Charisma()
        data object Performance : Charisma()
        data object Persuasion : Charisma()
    }
}
