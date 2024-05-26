package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills3
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Ranger(
    proficientSkills: Skills3,
) : Class(
    hpDice = Dice.D10,
    proficientSavingThrows = listOf(StatType.STR, StatType.DEX),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, Athletics, Perception, Survival, Nature, Insight, Stealth, AnimalHandling,
        )
    }
}
