package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.DEX
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.armor.ArmorChecker
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills4
import io.vbytsyuk.dnd.core.weapon.HandCrossbow
import io.vbytsyuk.dnd.core.weapon.Longsword
import io.vbytsyuk.dnd.core.weapon.Shortsword
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*

class Rogue(
    proficientSkills: Skills4,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(DEX, INT),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(simple = true, specific = setOf(Dagger, HandCrossbow, Longsword, Rapier, Shortsword)),
        armor = ArmorChecker(light = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Acrobatics, Investigation, Athletics, Perception, Performance, Intimidation, SleightOfHand, Deception,
            Insight, Stealth, Persuasion
        )
    }
}
