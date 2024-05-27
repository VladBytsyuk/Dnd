package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills3
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Ranger(
    proficientSkills: Skills3,
) : Class(
    hpDice = Dice.D10,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.STR, StatType.DEX),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { true },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, Athletics, Perception, Survival, Nature, Insight, Stealth, AnimalHandling,
        )
    }
}
