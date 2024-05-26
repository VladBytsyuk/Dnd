package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Wizard(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D6,
    proficientSavingThrows = listOf(StatType.INT, StatType.WIS),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, History, Arcana, Medicine, Insight, Religion,
        )
    }
}
