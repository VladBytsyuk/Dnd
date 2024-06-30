package io.vbytsyuk.dnd.core.race

import io.vbytsyuk.dnd.core.units.Speed
import io.vbytsyuk.dnd.core.StatBlock
import io.vbytsyuk.dnd.core.proficiencies.Proficiencies
import io.vbytsyuk.dnd.core.units.Language.Common
import io.vbytsyuk.dnd.core.units.Language.Infernal
import io.vbytsyuk.dnd.core.units.feet
import io.vbytsyuk.dnd.core.units.Size

sealed class Tiefling(
    override val bonusStatBlock: StatBlock,
) : Race {

    override val size = Size.MEDIUM
    override val baseSpeed = Speed(30.feet)
    override val darkVision = 60.feet
    override val proficiencies = Proficiencies(
        languages = { it in listOf(Common, Infernal) },
    )

    data object Asmodeus : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Baalzebul : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Dispater : Tiefling(bonusStatBlock = StatBlock(charisma = 2, dexterity = 1))
    data object Fierna : Tiefling(bonusStatBlock = StatBlock(charisma = 2, wisdom = 1))
    data object Glasya : Tiefling(bonusStatBlock = StatBlock(charisma = 2, dexterity = 1))
    data object Levistus : Tiefling(bonusStatBlock = StatBlock(charisma = 2, constitution = 1))
    data object Mammon : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Mephistopheles : Tiefling(bonusStatBlock = StatBlock(charisma = 2, intelligence = 1))
    data object Zariel : Tiefling(bonusStatBlock = StatBlock(charisma = 2, strength = 1))
}