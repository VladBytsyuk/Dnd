package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.CHA
import io.vbytsyuk.dnd.domain.StatType.WIS
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

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
