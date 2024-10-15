package io.vbytsyuk.dnd.domain.race

import io.vbytsyuk.dnd.domain.units.Speed
import io.vbytsyuk.dnd.domain.StatBlock
import io.vbytsyuk.dnd.domain.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.language.Language
import io.vbytsyuk.dnd.domain.language.Language.Common
import io.vbytsyuk.dnd.domain.language.LanguageChecker
import io.vbytsyuk.dnd.domain.units.feet
import io.vbytsyuk.dnd.domain.units.Size

sealed class Halfling(
    override val bonusStatBlock: StatBlock,
) : Race {

    override val size = Size.SMALL
    override val baseSpeed = Speed(25.feet)
    override val darkVision = null
    override val proficiencies = Proficiencies(
        languages = LanguageChecker(specific = setOf(Common, Language.Halfling)),
    )

    data object Stout : Halfling(bonusStatBlock = StatBlock(dexterity = 2, constitution = 1))
    data object Lightfoot : Halfling(bonusStatBlock = StatBlock(dexterity = 2, charisma = 1))
}
