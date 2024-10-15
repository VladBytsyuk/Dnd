package io.vbytsyuk.dnd.domain.core.`class`

import io.vbytsyuk.dnd.domain.core.Dice
import io.vbytsyuk.dnd.domain.core.StatType.CHA
import io.vbytsyuk.dnd.domain.core.StatType.DEX
import io.vbytsyuk.dnd.domain.core.armor.ArmorChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills3
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Deception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Performance
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Persuasion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.Acrobatics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.SleightOfHand
import io.vbytsyuk.dnd.domain.core.skills.Skill.Dexterity.Stealth
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Arcana
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.History
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Investigation
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Nature
import io.vbytsyuk.dnd.domain.core.skills.Skill.Intelligence.Religion
import io.vbytsyuk.dnd.domain.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.AnimalHandling
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Insight
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Medicine
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Perception
import io.vbytsyuk.dnd.domain.core.skills.Skill.Wisdom.Survival
import io.vbytsyuk.dnd.domain.core.weapon.HandCrossbow
import io.vbytsyuk.dnd.domain.core.weapon.Longsword
import io.vbytsyuk.dnd.domain.core.weapon.Rapier
import io.vbytsyuk.dnd.domain.core.weapon.Shortsword
import io.vbytsyuk.dnd.domain.core.weapon.WeaponChecker

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
