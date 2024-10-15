package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.CHA
import io.vbytsyuk.dnd.domain.StatType.WIS
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Cleric(
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
        armor = ArmorChecker(light = true, medium = true, shield = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            History, Medicine, Insight, Religion, Persuasion,
        )
    }
}
