package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Strength.Athletics
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Barbarian(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D12,
    proficientSavingThrows = listOf(StatType.STR, StatType.CON),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object{
        val allowedProficientSkills = listOf(
            Athletics, Perception, Survival, Intimidation, Nature, AnimalHandling,
        )
    }
}
