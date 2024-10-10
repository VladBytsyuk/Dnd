package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.CHA
import io.vbytsyuk.dnd.core.StatType.WIS
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

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
        weapons = WeaponChecker(simple = true),
        armor = ArmorChecker(light = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, Intimidation, History, Arcana, Deception, Nature, Religion,
        )
    }
}
