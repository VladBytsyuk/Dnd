package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Dexterity.*
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*

class Artificer(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D8,
    proficientSavingThrows = listOf(StatType.CON, StatType.INT),
    allowedProficientSkills = Companion.allowedProficientSkills,
    selectedProficientSkills = proficientSkills,
) {

    companion object {
        val allowedProficientSkills = listOf(
            Arcana, History, Investigation, Medicine, Nature, Perception, SleightOfHand
        )
    }
}
