package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.CHA
import io.vbytsyuk.dnd.domain.core.StatType.WIS
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
