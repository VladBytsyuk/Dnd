package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.DEX
import io.vbytsyuk.dnd.domain.StatType.INT
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills4
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Performance
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.SleightOfHand
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.weapon.Dagger
import io.vbytsyuk.dnd.domain.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.weapon.Longsword
import io.vbytsyuk.dnd.domain.weapon.Rapier
import io.vbytsyuk.dnd.domain.weapon.Shortsword
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Rogue(
    proficientSkills: Skills4,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies by lazy {
        Proficiencies(
        savingThrows = listOf(DEX, INT),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(simple = true, specific = setOf(Dagger, HandCrossbow, Longsword, Rapier, Shortsword)),
        armor = ArmorChecker(light = true),
    )
    }

    companion object {
        val allowedProficientSkills = listOf(
            Acrobatics, Investigation, Athletics, Perception, Performance, Intimidation, SleightOfHand, Deception,
            Insight, Stealth, Persuasion
        )
    }
}
