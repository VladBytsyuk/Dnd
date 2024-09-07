package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CHA
import io.vbytsyuk.dnd.core.StatType.WIS
import io.vbytsyuk.dnd.core.armor.Armor.Type.Light
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE

class Warlock(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(WIS, CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it.proficiencyType == SIMPLE },
        armor = ArmorChecker(light = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, Intimidation, History, Arcana, Deception, Nature, Religion,
        )
    }
}
