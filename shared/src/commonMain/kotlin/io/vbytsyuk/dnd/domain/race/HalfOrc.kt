package io.vbytsyuk.dnd.domain.race

import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.language.Language.Common
import io.vbytsyuk.dnd.domain.language.Language.Orc
import io.vbytsyuk.dnd.domain.language.LanguageChecker
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.proficiencies.Skills
import io.vbytsyuk.dnd.domain.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.units.Size
import io.vbytsyuk.dnd.domain.units.Speed
import io.vbytsyuk.dnd.domain.units.feet

data object HalfOrc : Race {

    override val bonusStatBlock = StatBlock(strength = 2, constitution = 1)
    override val size = Size.MEDIUM
    override val baseSpeed = Speed(30.feet)
    override val darkVision = 60.feet
    override val proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = Skills(Intimidation)),
        languages = LanguageChecker(specific = setOf(Common, Orc)),
    )
}
