package io.vbytsyuk.dnd.core.character

import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Mastery.*
import io.vbytsyuk.dnd.core.units.MasteryModifier

typealias SavingThrowsMap = Map<StatType, MasteryModifier>

val Character.savingThrows: SavingThrowsMap get() = buildMap {
    val proficientSavingThrowsList = `class`.proficiencies.savingThrows + race.proficiencies.savingThrows
    StatType.entries.forEach { stat ->
        val mastery = when {
            stat in proficientSavingThrowsList -> PROFICIENT
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
