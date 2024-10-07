package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.StatType
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.proficiencies.ProficiencySkills
import io.vbytsyuk.dnd.core.proficiencies.Skills2
import io.vbytsyuk.dnd.core.language.Language
import io.vbytsyuk.dnd.core.language.Language.Common
import io.vbytsyuk.dnd.core.language.Language.Elvish
import io.vbytsyuk.dnd.core.language.LanguageChecker
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

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
