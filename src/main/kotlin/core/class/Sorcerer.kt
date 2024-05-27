package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*

class Sorcerer(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D6,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.CON, StatType.CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it in setOf(Quarterstaff, Dart, Dagger, LightCrossbow, Sling) },
        armor = { false },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Intimidation, Arcana, Deception, Insight, Religion, Persuasion,
        )
    }
}
