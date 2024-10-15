package io.vbytsyuk.dnd.domain.core.skills

import io.vbytsyuk.dnd.domain.core.StatType

sealed class Skill(val originStatType: StatType) {

    sealed class Strength : Skill(originStatType = StatType.STR) {

        /** Атлетика */
        data object Athletics : Strength()

        companion object {
            val all = listOf(Athletics)
        }
    }

    sealed class Dexterity : Skill(originStatType = StatType.DEX) {

        /** Акробатика */
        data object Acrobatics : Dexterity()

        /** Ловкость рук */
        data object SleightOfHand : Dexterity()

        /** Скрытность */
        data object Stealth : Dexterity()

        companion object {
            val all = listOf(Acrobatics, SleightOfHand, Stealth)
        }
    }

    data object Constitution : Skill(originStatType = StatType.CON) {

        val all = emptyList<Constitution>()
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

        companion object {
            val all = listOf(Arcana, History, Investigation, Nature, Religion)
        }
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

        companion object {
            val all = listOf(AnimalHandling, Insight, Medicine, Perception, Survival)
        }
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

        companion object {
            val all = listOf(Deception, Intimidation, Performance, Persuasion)
        }
    }

    companion object {
        fun all() = Strength.all + Dexterity.all + Constitution.all + Intelligence.all + Wisdom.all + Charisma.all
    }
}
