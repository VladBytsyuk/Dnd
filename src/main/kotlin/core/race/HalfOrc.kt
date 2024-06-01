package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills1
import io.vbytsyuk.dnd.core.skills.Skill
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

data object HalfOrc : Race(
    bonusStatBlock = StatBlock(strength = 2, constitution = 1),
    size = Size.MEDIUM,
    baseSpeed = Speed(30.feet),
    darkVision = 60.feet,
    proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = Skills1(Skill.Charisma.Intimidation)),
    ),
)