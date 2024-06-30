package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills
import io.vbytsyuk.dnd.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.core.units.Language.Common
import io.vbytsyuk.dnd.core.units.Language.Orc
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

data object HalfOrc : Race {

    override val bonusStatBlock = StatBlock(strength = 2, constitution = 1)
    override val size = Size.MEDIUM
    override val baseSpeed = Speed(30.feet)
    override val darkVision = 60.feet
    override val proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = Skills(Intimidation)),
        languages = { it in listOf(Common, Orc) }
    )
}