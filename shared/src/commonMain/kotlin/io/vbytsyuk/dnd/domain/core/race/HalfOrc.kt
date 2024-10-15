package io.vbytsyuk.dnd.domain.core.race

import io.vbytsyuk.dnd.domain.core.StatBlock
import io.vbytsyuk.dnd.domain.core.language.Language.Common
import io.vbytsyuk.dnd.domain.core.language.Language.Orc
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills
import io.vbytsyuk.dnd.domain.core.skills.Skill.Charisma.Intimidation
import io.vbytsyuk.dnd.domain.core.units.Size
import io.vbytsyuk.dnd.domain.core.units.Speed
import io.vbytsyuk.dnd.domain.core.units.feet

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
