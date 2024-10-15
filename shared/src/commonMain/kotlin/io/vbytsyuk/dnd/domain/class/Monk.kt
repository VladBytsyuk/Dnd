package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.DEX
import io.vbytsyuk.dnd.domain.StatType.STR
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.weapon.Shortsword
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

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
