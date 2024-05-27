package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.armor.Armor.Type.Light
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills3
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*
import io.vbytsyuk.dnd.core.weapon.Weapon.ProficiencyType.SIMPLE

class Bard(
    proficientSkills: Skills3,
) : Class(
    hpDice = Dice.D8,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.DEX, StatType.CHA),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it.proficiencyType == SIMPLE || it in setOf(Longsword, Shortsword, Rapier, HandCrossbow) },
        armor = {  it.type is Light },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Athletics, Acrobatics, SleightOfHand, Stealth, Arcana, History, Investigation, Nature, Religion, AnimalHandling,
            Insight, Medicine, Perception, Survival, Deception, Persuasion, Performance, Intimidation,
        )
    }
}
