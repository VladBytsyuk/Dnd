package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CHA
import io.vbytsyuk.dnd.core.StatType.CON
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.weapon.LightCrossbow
import io.vbytsyuk.dnd.core.weapon.Quarterstaff
import io.vbytsyuk.dnd.core.weapon.Sling
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*

class Sorcerer(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D6
    override val proficiencies = Proficiencies(
        savingThrows = listOf(CON, CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(specific = setOf(Quarterstaff, Dart, Dagger, LightCrossbow, Sling)),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Intimidation, Arcana, Deception, Insight, Religion, Persuasion,
        )
    }
}
