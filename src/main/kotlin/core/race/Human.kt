package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Language
import io.vbytsyuk.dnd.core.units.Language.Common
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

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
        languages = { it in listOf(Common, chosenLanguage) }
    )

    init { requireUniqueChosenLanguage() }

    private fun requireUniqueChosenLanguage() = require(chosenLanguage != Common)
}
