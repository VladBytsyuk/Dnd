package io.vbytsyuk.dnd.domain.core.character

import io.vbytsyuk.dnd.domain.core.StatType
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.COMPETENT
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.NONE
import io.vbytsyuk.dnd.domain.core.proficiencies.Mastery.PROFICIENT
import io.vbytsyuk.dnd.domain.core.units.MasteryModifier

typealias SavingThrowsMap = Map<StatType, MasteryModifier>

val Character.savingThrows: SavingThrowsMap
    get() = buildMap {
    StatType.entries.forEach { stat ->
        val mastery = when {
            stat in proficiencies.savingThrows -> PROFICIENT
            else -> NONE
        }
        val modifierFromStatBlock = statBlock.modifier(stat)
        val modifier = when (mastery) {
            COMPETENT -> modifierFromStatBlock + proficiencyBonus + proficiencyBonus
            PROFICIENT -> modifierFromStatBlock + proficiencyBonus
            else -> modifierFromStatBlock
        }
        this += stat to MasteryModifier(mastery, modifier)
    }
}
