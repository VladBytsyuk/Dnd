package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Fighter(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D10,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.STR, StatType.CON),
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
            Athletics, Acrobatics, Perception, Survival, Intimidation, History, Insight, AnimalHandling,
        )
    }
}
