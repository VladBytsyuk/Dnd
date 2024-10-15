package io.vbytsyuk.dnd.domain.`class`

import io.vbytsyuk.dnd.domain.Dice
import io.vbytsyuk.dnd.domain.StatType.CHA
import io.vbytsyuk.dnd.domain.StatType.DEX
import io.vbytsyuk.dnd.domain.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills3
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Performance
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.SleightOfHand
import io.vbytsyuk.dnd.domain.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.weapon.Longsword
import io.vbytsyuk.dnd.domain.weapon.Rapier
import io.vbytsyuk.dnd.domain.weapon.Shortsword
import io.vbytsyuk.dnd.domain.weapon.WeaponChecker

class Bard(
    proficientSkills: Skills3,
) : Class {

    override val hpDice = Dice.D8
    override val proficiencies = Proficiencies(
        savingThrows = listOf(DEX, CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = WeaponChecker(simple = true, specific = setOf(Longsword, Shortsword, Rapier, HandCrossbow)),
        armor = ArmorChecker(light = true),
    )

    companion object {
        val allowedProficientSkills = listOf(
            Athletics, Acrobatics, SleightOfHand, Stealth, Arcana, History, Investigation, Nature, Religion,
            AnimalHandling, Insight, Medicine, Perception, Survival, Deception, Persuasion, Performance, Intimidation,
        )
    }
}
