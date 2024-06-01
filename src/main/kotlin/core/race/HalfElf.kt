package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

data class HalfElf(
    val chosenStat1: StatType,
    val chosenStat2: StatType,
    val chosenSkills: Skills2,
) : Race(
    bonusStatBlock = StatBlock(charisma = 2).applyChosenStats(chosenStat1, chosenStat2),
    size = Size.MEDIUM,
    baseSpeed = Speed(30.feet),
    darkVision = 60.feet,
    proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = chosenSkills),
    ),
)
