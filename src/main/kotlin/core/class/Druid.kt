package io.vbytsyuk.dnd.core.`class`

import io.vbytsyuk.dnd.core.Dice
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.skills.Skill.Intelligence.*
import io.vbytsyuk.dnd.core.skills.Skill.Wisdom.*
import io.vbytsyuk.dnd.core.weapon.*

class Druid(
    proficientSkills: Skills2,
) : Class(
    hpDice = Dice.D8,
    proficiencies = Proficiencies(
        savingThrows = listOf(StatType.INT, StatType.WIS),
        skills = ProficiencySkills(
            allowed = allowedProficientSkills,
            selected = proficientSkills,
        ),
        weapons = { it in setOf(Quarterstaff, Mace, Dart, Club, Dagger, Spear, Javelin, Sling, Sickle, Scimitar) },
    ),
) {

    companion object {
        val allowedProficientSkills = listOf(
            Perception, Survival, Arcana, Medicine, AnimalHandling, Nature, Insight, Religion,
        )
    }
}
