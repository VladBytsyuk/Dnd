package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType.INT
import io.vbytsyuk.dnd.core.StatType.WIS
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*

class Wizard(
    proficientSkills: Skills2,
) : Class {

    override val hpDice = Dice.D6
    override val proficiencies = Proficiencies(
        savingThrows = listOf(INT, WIS),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it in setOf(Dagger, Dart, Sling, Quarterstaff, LightCrossbow) },
    )

    companion object {
        val allowedProficientSkills = listOf(
            Investigation, History, Arcana, Medicine, Insight, Religion,
        )
    }
}
