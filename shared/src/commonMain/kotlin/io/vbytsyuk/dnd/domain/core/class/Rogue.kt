package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.DEX
import io.vbytsyuk.dnd.domain.core.StatType.INT
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills4
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Performance
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.SleightOfHand
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.core.weapon.Dagger
import io.vbytsyuk.dnd.domain.core.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.core.weapon.Longsword
import io.vbytsyuk.dnd.domain.core.weapon.Rapier
import io.vbytsyuk.dnd.domain.core.weapon.Shortsword
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
