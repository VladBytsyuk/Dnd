package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Paladin(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D10,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.WIS, StatType.CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { true },
        armor = { true },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Athletics, Intimidation, Medicine, Insight, Religion, Persuasion,
        )
    }
}
