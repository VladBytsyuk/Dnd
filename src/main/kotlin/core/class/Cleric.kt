package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Cleric(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D8,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.WIS, StatType.CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            History, Medicine, Insight, Religion, Persuasion,
        )
    }
}
