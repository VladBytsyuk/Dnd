package io.vbytsyuk.dnd.domain.core.race

import io.vbytsyuk.dnd.domain.core.units.Speed
import io.vbytsyuk.dnd.domain.core.StatBlock
import io.vbytsyuk.dnd.domain.core.StatType
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.domain.core.proficiencies.Skills2
import io.vbytsyuk.dnd.domain.core.language.Language
import io.vbytsyuk.dnd.domain.core.language.Language.Common
import io.vbytsyuk.dnd.domain.core.language.Language.Elvish
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.units.feet
import io.vbytsyuk.dnd.domain.core.units.Size

data class HalfElf(
    val chosenStat1: StatType,
    val chosenStat2: StatType,
    val chosenSkills: Skills2,
    val chosenLanguage: Language,
) : Race {

    override val bonusStatBlock = StatBlock(charisma = 2).applyChosenStats(chosenStat1, chosenStat2)
    override val size = Size.MEDIUM
    override val baseSpeed = Speed(30.feet)
    override val darkVision = 60.feet
    override val proficiencies = Proficiencies(
        skills = ProficiencySkills(selected = chosenSkills),
        languages = LanguageChecker(specific = setOf(Common, Elvish, chosenLanguage)),
    )

    init { requireUniqueChosenLanguage() }

    private fun requireUniqueChosenLanguage() = require(chosenLanguage != Common && chosenLanguage != Elvish)
}
