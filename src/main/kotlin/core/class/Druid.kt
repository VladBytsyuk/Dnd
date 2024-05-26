package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Druid(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D8,
    proficientSavingThrows = listOf(StatType.INT, StatType.WIS),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object {
        val allowedProficientSkills = listOf(
            Perception, Survival, Arcana, Medicine, AnimalHandling, Nature, Insight, Religion,
        )
    }
}
