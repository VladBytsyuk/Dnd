package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills4
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Rogue(
    proficientSkills: Skills4,
) : Class(
    hpDice = Dice.D8,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.DEX, StatType.INT),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Acrobatics, Investigation, Athletics, Perception, Performance, Intimidation, SleightOfHand, Deception,
            Insight, Stealth, Persuasion
        )
    }
}
