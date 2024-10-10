package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.DEX
import io.vbytsyuk.dnd.core.StatType.STR
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.core.weapon.Shortsword
import io.vbytsyuk.dnd.core.weapon.WeaponChecker

class Monk(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(STR, DEX),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(simple = true, specific = setOf(Shortsword)),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Acrobatics, Athletics, History, Insight, Religion, Stealth,
        )
    }
}
