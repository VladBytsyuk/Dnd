package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.Shortsword
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE

class Monk(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D8,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.STR, StatType.DEX),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it.proficiencyType == SIMPLE || it == Shortsword },
        armor = { false },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Acrobatics, Athletics, History, Insight, Religion, Stealth,
        )
    }
}
