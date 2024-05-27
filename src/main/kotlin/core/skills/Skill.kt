package io.vbytsyuk.dnd.core.skills

import io.vbytsyuk.dnd.core.StatType

sealed class Skill(val originStatType: StatType) {

    sealed class Strength : Skill(originStatType = StatType.STR) {

        /** Атлетика */
        data object Athletics : Strength()
    }

    sealed class Dexterity : Skill(originStatType = StatType.DEX) { 

        /** Акробатика */
        data object Acrobatics : Dexterity()

        /** Ловкость рук */
        data object SleightOfHand : Dexterity()

        /** Скрытность */
        data object Stealth : Dexterity()
    }

    sealed class Intelligence : Skill(originStatType = StatType.INT) {

        /** Магия */
        data object Arcana : Intelligence()

        /** История */
        data object History : Intelligence()

        /** Анализ */
        data object Investigation : Intelligence()

        /** Природа */
        data object Nature : Intelligence()

        /** Религия */
        data object Religion : Intelligence()
    }

    sealed class Wisdom : Skill(originStatType = StatType.WIS) {

        /** Уход за животными */
        data object AnimalHandling : Wisdom()

        /** Проницательность */
        data object Insight : Wisdom()

        /** Медицина */
        data object Medicine : Wisdom()

        /** Внимательность */
        data object Perception : Wisdom()

        /** Выживание */
        data object Survival : Wisdom()
    }

    sealed class Charisma : Skill(originStatType = StatType.CHA) {

        /** Обман */
        data object Deception : Charisma()

        /** Запугивание*/
        data object Intimidation : Charisma()

        /** Выступление */
        data object Performance : Charisma()

        /** Убеждение */
        data object Persuasion : Charisma()
    }

    companion object {
        val skillsSet = setOf(
            Strength.Athletics,
            Dexterity.Acrobatics,
            Dexterity.SleightOfHand,
            Dexterity.Stealth,
            Intelligence.Arcana,
            Intelligence.Nature,
            Intelligence.History,
            Intelligence.Religion,
            Intelligence.Investigation,
            Wisdom.Insight,
            Wisdom.Survival,
            Wisdom.Medicine,
            Wisdom.Perception,
            Wisdom.AnimalHandling,
            Charisma.Persuasion,
            Charisma.Deception,
            Charisma.Performance,
            Charisma.Intimidation,
        )
    }
}
