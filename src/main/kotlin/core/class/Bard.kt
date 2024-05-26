package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills3
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Bard(
    proficientSkills: Skills3,
) : Class(
    hpDice = Dice.D8,
    proficientSavingThrows = listOf(StatType.DEX, StatType.CHA),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object {
        val allowedProficientSkills = listOf(
            Athletics, Acrobatics, SleightOfHand, Stealth, Arcana, History, Investigation, Nature, Religion, AnimalHandling,
            Insight, Medicine, Perception, Survival, Deception, Persuasion, Performance, Intimidation,
        )
    }
}
