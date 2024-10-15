package io.vbytsyuk.dnd.domain.race

import io.vbytsyuk.dnd.domain.units.Speed
import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.language.Language.Common
import io.vbytsyuk.dnd.domain.language.LanguageChecker
import io.vbytsyuk.dnd.domain.units.feet
import io.vbytsyuk.dnd.domain.units.Size

data class Human(
    val chosenLanguage: Language,
) : Race {

    override val bonusStatBlock = StatBlock(
        strength = 1,
        dexterity = 1,
        constitution = 1,
        intelligence = 1,
        wisdom = 1,
        charisma = 1,
    )
    override val size = Size.MEDIUM
    override val baseSpeed = Speed(30.feet)
    override val proficiencies = Proficiencies(
        languages = LanguageChecker(specific = setOf(Common, chosenLanguage)),
    )

    init { requireUniqueChosenLanguage() }

    private fun requireUniqueChosenLanguage() = require(chosenLanguage != Common)
}
