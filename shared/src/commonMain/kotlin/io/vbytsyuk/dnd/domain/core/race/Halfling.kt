package io.vbytsyuk.dnd.domain.core.race

import io.vbytsyuk.dnd.domain.core.units.Speed
import io.vbytsyuk.dnd.domain.core.StatBlock
import io.vbytsyuk.dnd.domain.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.domain.core.language.Language
import io.vbytsyuk.dnd.domain.core.language.Language.Common
import io.vbytsyuk.dnd.domain.core.language.LanguageChecker
import io.vbytsyuk.dnd.domain.core.units.feet
import io.vbytsyuk.dnd.domain.core.units.Size

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
